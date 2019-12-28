package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.City;
import com.briup.apps.zhaopin.bean.extend.CityExtend;

import java.util.List;


public interface CityService {

    List<City> findAll();

    String saveOrUpdate(City city);

    City findById(Long id);

    void deleteById(Long id);

    List<CityExtend> findByProvinceId(Long provinceid);

}
