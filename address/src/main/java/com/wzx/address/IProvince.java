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

public interface IProvince extends IName{
    List<City> getCity();
}
