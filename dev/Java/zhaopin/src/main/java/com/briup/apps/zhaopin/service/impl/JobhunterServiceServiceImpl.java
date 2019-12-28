package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.JobhunterService;
import com.briup.apps.zhaopin.bean.JobhunterServiceExample;
import com.briup.apps.zhaopin.mapper.JobhunterServiceMapper;
import com.briup.apps.zhaopin.service.JobhunterServiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @program: JobhunterServiceServiceImpl
 * @description: 客服服务接口实现类
 * @author: CC
 * @create: 2019/9/21 9:19
 */
@Service
public class JobhunterServiceServiceImpl implements JobhunterServiceService {
    @Resource
    private JobhunterServiceMapper jobhunterServiceMapper;
    @Override
    public List<JobhunterService> findAll() {
        return jobhunterServiceMapper.selectByExample(new JobhunterServiceExample());
    }

    @Override
    public String saveOrUpdate(JobhunterService jobhunterService) {
        if (jobhunterService.getId()==null){
            jobhunterServiceMapper.insert(jobhunterService);
            return "新增成功";
        }else {
            jobhunterServiceMapper.updateByPrimaryKey(jobhunterService);
            return "更新成功";
        }
    }

    @Override
    public JobhunterService findById(Long id) {
        return jobhunterServiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        jobhunterServiceMapper.deleteByPrimaryKey(id);
    }
}