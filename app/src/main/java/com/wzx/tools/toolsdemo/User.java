package com.wzx.tools.toolsdemo;

/**
 * 描述：
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/9
 * 更新时间：
 * 更新内容：
 */

public class User {

    private String name;
    private String sex;

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex == null ? "" : sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
