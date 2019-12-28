package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.Jobs;
import com.briup.apps.zhaopin.bean.extend.JobsExtend;

import java.util.List;

public interface JobsService {
    List<Jobs> findAll();

    String saveOrUpdate(Jobs jobs);

    Jobs findById(Long id);

    List<JobsExtend> findByStatus(String status);

    void deleteById(Long id);
}
