package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.JobType;

import java.util.List;

public interface JobTypeService {
    List<JobType> findAll();

    String saveOrUpdate(JobType jobs);

    JobType findById(Long id);

    void deleteById(Long id);
}
