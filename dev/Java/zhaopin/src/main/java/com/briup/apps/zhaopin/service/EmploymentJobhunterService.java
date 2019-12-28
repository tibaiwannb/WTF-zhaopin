package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.EmploymentJobhunter;
import com.briup.apps.zhaopin.bean.extend.EmploymentJobhunterExtend;

import java.util.List;

public interface EmploymentJobhunterService {
    List<EmploymentJobhunter> findAll();

    String saveOrUpdate(EmploymentJobhunter EmploymentJobhunter);

    EmploymentJobhunter findById(Long id);

    void deleteById(Long id);

    List<EmploymentJobhunterExtend> findAllWithJobhAndEmpl();
}
