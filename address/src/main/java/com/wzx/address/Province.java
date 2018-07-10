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

public class Province implements IProvince {

    private String name;
    private List<City> city;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<City> getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
