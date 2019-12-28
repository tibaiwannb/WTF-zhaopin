package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.Welfare;

import java.util.List;

public interface WelfareService {
    List<Welfare> findAll();

    String saveOrUpdate(Welfare welfare);

    Welfare findById(Long id);

    void deleteById(Long id);
}
