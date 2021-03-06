package com.wzx.tools.log;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.wzx.tools.StringUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import static com.wzx.tools.StringUtils.checkNotNull;
import static com.wzx.tools.log.Logger.ASSERT;
import static com.wzx.tools.log.Logger.DEBUG;
import static com.wzx.tools.log.Logger.ERROR;
import static com.wzx.tools.log.Logger.INFO;
import static com.wzx.tools.log.Logger.VERBOSE;
import static com.wzx.tools.log.Logger.WARN;

/**
 * 描述：实现{@link IPrinter}打印方式
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/2
 * 更新时间：
 * 更新内容：
 */

public class LoggerPrinter implements IPrinter {
    /**
     * It is used for json pretty print
     */
    private static final int JSON_INDENT = 2;

    /**
     * Provides one-time used tag for the log message
     */
    private final ThreadLocal<String> localTag = new ThreadLocal<>();

    private final List<LogAdapter> logAdapters = new ArrayList<>();

    @Override
    public IPrinter t(String tag) {
        if (tag != null) {
            localTag.set(tag);
        }
        return this;
    }

    @Override
    public void d(@NonNull String message, @Nullable Object... args) {
        log(DEBUG, null, message, args);
    }

    @Override
    public void d(@Nullable Object object) {
        log(DEBUG, null, StringUtils.toString(object));
    }

    @Override
    public void e(@NonNull String message, @Nullable Object... args) {
        e(null, message, args);
    }

    @Override
    public void e(@Nullable Throwable throwable, @NonNull String message, @Nullable Object... args) {
        log(ERROR, throwable, message, args);
    }

    @Override
    public void w(@NonNull String message, @Nullable Object... args) {
        log(WARN, null, message, args);
    }

    @Override
    public void i(@NonNull String message, @Nullable Object... args) {
        log(INFO, null, message, args);
    }

    @Override
    public void v(@NonNull String message, @Nullable Object... args) {
        log(VERBOSE, null, message, args);
    }

    @Override
    public void wtf(@NonNull String message, @Nullable Object... args) {
        log(ASSERT, null, message, args);
    }

    @Override
    public void json(@Nullable String json) {
        if (StringUtils.isEmpty(json)) {
            d("Empty/Null json content");
            return;
        }
        try {
            json = json.trim();
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                i(json + "\n" + jsonObject.toString(JSON_INDENT));
                return;
            }
            if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                String message = jsonArray.toString(JSON_INDENT);
                i(message);
                return;
            }
            e("Invalid Json");
        } catch (JSONException e) {
            e("Invalid Json");
        }
    }

    @Override
    public void xml(@Nullable String xml) {
        if (StringUtils.isEmpty(xml)) {
            d("Empty/Null xml content");
            return;
        }
        try {
            Source xmlInput = new StreamSource(new StringReader(xml));
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(xmlInput, xmlOutput);
            i(xmlOutput.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (TransformerException e) {
            e("Invalid xml");
        }
    }

    @Override
    public synchronized void log(int priority,
                                 @Nullable String tag,
                                 @Nullable String message,
                                 @Nullable Throwable throwable) {
        if (throwable != null && message != null) {
            message += " : " + StringUtils.getStackTraceString(throwable);
        }
        if (throwable != null && message == null) {
            message = StringUtils.getStackTraceString(throwable);
        }
        if (StringUtils.isEmpty(message)) {
            message = "Empty/NULL log message";
        }

        for (LogAdapter adapter : logAdapters) {
            if (adapter.isLoggable(priority, tag)) {
                adapter.log(priority, tag, message);
            }
        }
    }

    @Override
    public void clearLogAdapters() {
        logAdapters.clear();
    }

    @Override
    public void addAdapter(@NonNull LogAdapter adapter) {
        logAdapters.add(checkNotNull(adapter));
    }

    /**
     * This method is synchronized in order to avoid messy of logs' order.
     */
    private synchronized void log(int priority,
                                  @Nullable Throwable throwable,
                                  @NonNull String msg,
                                  @Nullable Object... args) {
        checkNotNull(msg);

        String tag = getTag();
        String message = createMessage(msg, args);
        log(priority, tag, message, throwable);
    }

    /**
     * @return the appropriate tag based on local or global
     */
    @Nullable
    private String getTag() {
        String tag = localTag.get();
        if (tag != null) {
            localTag.remove();
            return tag;
        }
        return null;
    }

    @NonNull
    private String createMessage(@NonNull String message, @Nullable Object... args) {
        return args == null || args.length == 0 ? message : String.format(message, args);
    }
}
