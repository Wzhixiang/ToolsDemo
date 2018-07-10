package com.wzx.address;

import java.util.List;

/**
 * 描述：
 * <p>
 * 创建人： Administrator
 * 创建时间： 2018/7/10
 * 更新时间：
 * 更新内容：
 */

public class City implements ICity {

    private String name;

    private List<String> area;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getArea() {
        return area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }

}
