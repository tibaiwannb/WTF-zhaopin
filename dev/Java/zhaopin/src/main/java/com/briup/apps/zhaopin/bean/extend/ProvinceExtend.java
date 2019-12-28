package com.briup.apps.zhaopin.bean.extend;

import com.briup.apps.zhaopin.bean.City;
import com.briup.apps.zhaopin.bean.Province;

/**
 * @program: ProvinceExtend
 * @description: 省份扩展类
 * @author: CC
 * @create: 2019/9/29 13:02
 */
public class ProvinceExtend extends Province {
    private City city;
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
}
