package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.JobhunterService;

import java.util.List;
public interface JobhunterServiceService {
    List<JobhunterService> findAll();

    String saveOrUpdate(JobhunterService jobhunterService);

    JobhunterService findById(Long id);

    void deleteById(Long id);
}
