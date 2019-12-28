package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.Jobs;
import com.briup.apps.zhaopin.bean.JobsExample;
import com.briup.apps.zhaopin.bean.extend.JobsExtend;
import com.briup.apps.zhaopin.mapper.JobsMapper;
import com.briup.apps.zhaopin.mapper.extend.JobsExtendMapper;
import com.briup.apps.zhaopin.service.JobsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: JobsServiceImpl
 * @description: 职位接口实现类
 * @author: CC
 * @create: 2019/9/21 9:13
 */

@Service
public class JobsServiceImpl implements JobsService {
    @Resource
    private JobsMapper jobsMapper;
    @Resource
    private JobsExtendMapper jobsExtendMapper;
    @Override
    public List<JobsExtend> findByStatus(String status) {
        return jobsExtendMapper.selectByStatus(status);
    }
    @Override
    public List<Jobs> findAll() {
        return jobsMapper.selectByExample(new JobsExample());
    }

    @Override
    public String saveOrUpdate(Jobs jobs) {
        if (jobs.getId()==null){
            jobsMapper.insert(jobs);
            return "新增成功";
        }else {
            jobsMapper.updateByPrimaryKey(jobs);
            return "更新成功";
        }
    }

    @Override
    public Jobs findById(Long id) {
        return jobsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        jobsMapper.deleteByPrimaryKey(id);
    }
}
