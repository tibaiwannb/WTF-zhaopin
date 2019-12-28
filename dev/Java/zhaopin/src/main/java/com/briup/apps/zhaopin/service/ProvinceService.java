package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    String saveOrUpdate(Province jobs);

    Province findById(Long id);

    void deleteById(Long id);
}
