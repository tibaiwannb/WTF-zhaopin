package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.Employment;
import com.briup.apps.zhaopin.bean.extend.EmploymentExtend;

import java.util.List;

public interface EmploymentService {
    List<Employment> findAll();

    String saveOrUpdate(Employment employment);

    Employment findById(Long id);

    void deleteById(Long id);

    List<EmploymentExtend> findByJob(String job);

    List<EmploymentExtend> findByTitle(String title);

    List<EmploymentExtend> findByCity(String city);

    List<EmploymentExtend> findByWelfare(String welfare);
}
