package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.JobType;
import com.briup.apps.zhaopin.bean.JobTypeExample;
import com.briup.apps.zhaopin.mapper.JobTypeMapper;
import com.briup.apps.zhaopin.service.JobTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: JobTypeServiceImpl
 * @description: 职位类型实现类
 * @author: CC
 * @create: 2019/9/26 14:41
 */@Service
public class JobTypeServiceImpl implements JobTypeService {
    @Resource
    private JobTypeMapper jobTypeMapper;
    @Override
    public List<JobType> findAll() {
        return jobTypeMapper.selectByExample(new JobTypeExample());
    }

    @Override
    public String saveOrUpdate(JobType jobhunter) {
        if (jobhunter.getId()==null){
            jobTypeMapper.insert(jobhunter);
            return "新增成功";
        }else {
            jobTypeMapper.updateByPrimaryKey(jobhunter);
            return "更新成功";
        }
    }

    @Override
    public JobType findById(Long id) {
        return jobTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        jobTypeMapper.deleteByPrimaryKey(id);
    }
}
