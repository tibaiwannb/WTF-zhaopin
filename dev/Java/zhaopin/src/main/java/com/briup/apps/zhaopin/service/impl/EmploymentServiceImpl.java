package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.Employment;
import com.briup.apps.zhaopin.bean.EmploymentExample;
import com.briup.apps.zhaopin.bean.extend.EmploymentExtend;
import com.briup.apps.zhaopin.mapper.EmploymentMapper;
import com.briup.apps.zhaopin.mapper.extend.EmploymentExtendMapper;
import com.briup.apps.zhaopin.service.EmploymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: EmploymentServiceImpl
 * @description: 招聘信息接口的实现类
 * @author: CC
 * @create: 2019/9/19 20:55
 */
@Service
public class EmploymentServiceImpl implements EmploymentService {
    @Resource
    private EmploymentMapper employmentMapper;
    @Resource
    private EmploymentExtendMapper employmentExtendMapper;
    @Override
    public List<Employment> findAll() {
        return employmentMapper.selectByExample(new EmploymentExample());
    }

    @Override
    public String saveOrUpdate(Employment employment) {
        if (employment.getId()==null){
            employmentMapper.insert(employment);
            return "新增成功";
        }else {
            employmentMapper.updateByPrimaryKey(employment);
            return "更新成功";
        }
    }

    @Override
    public Employment findById(Long id) {
        return employmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        employmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<EmploymentExtend> findByJob(String job) {
        return employmentExtendMapper.selectByJob(job);
    }

    @Override
    public List<EmploymentExtend> findByTitle(String title) {
        return employmentExtendMapper.selectByTitle(title);
    }

    @Override
    public List<EmploymentExtend> findByCity(String city) {
        return employmentExtendMapper.selectByCity(city);
    }

    @Override
    public List<EmploymentExtend> findByWelfare(String welfare) {
        return employmentExtendMapper.selectByWelfare(welfare);
    }
}
