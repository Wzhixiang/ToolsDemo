package com.wzx.tools;

import com.wzx.tools.efficient.EfficientUtils;
import com.wzx.tools.efficient.ITodo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void about1000To100() throws Exception {
        EfficientUtils.executionTime(new ITodo() {
            @Override
            public void todo() {
                System.out.println(while100To1000(100000, 1000));
            }
        });
    }

    @Test
    public void about100To1000() throws Exception {
        EfficientUtils.executionTime(new ITodo() {
            @Override
            public void todo() {
                System.out.println(while100To1000(1000, 100000));
            }
        });
    }

    public int while100To1000(int one, int two) {
        int sum = 0;
        for (int i = 0; i < one; i++) {
            for (int j = 0; j < two; j++) {
                sum++;
            }
        }
        return sum;
    }
}