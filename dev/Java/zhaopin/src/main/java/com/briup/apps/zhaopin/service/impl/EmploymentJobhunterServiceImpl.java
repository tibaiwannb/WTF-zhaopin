package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.EmploymentJobhunter;
import com.briup.apps.zhaopin.bean.EmploymentJobhunterExample;
import com.briup.apps.zhaopin.bean.extend.EmploymentJobhunterExtend;
import com.briup.apps.zhaopin.mapper.EmploymentJobhunterMapper;
import com.briup.apps.zhaopin.mapper.extend.EmploymentJobhunterExtendMapper;
import com.briup.apps.zhaopin.service.EmploymentJobhunterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: EmploymentJobhunterServiceImpl
 * @description: 求职信息接口的实现类
 * @author: CC
 * @create: 2019/9/19 21:01
 */
@Service
public class EmploymentJobhunterServiceImpl implements EmploymentJobhunterService {
    @Resource
    private EmploymentJobhunterMapper employmentJobhunterMapper;
    @Resource
    private EmploymentJobhunterExtendMapper employmentJobhunterExtendMapper;
    @Override
    public List<EmploymentJobhunter> findAll() {
        return employmentJobhunterMapper.selectByExample(new EmploymentJobhunterExample());
    }

    @Override
    public String saveOrUpdate(EmploymentJobhunter employmentJobhunter) {
        if (employmentJobhunter.getId()==null){
            employmentJobhunterMapper.insert(employmentJobhunter);
            return "新增成功";
        }else {
            employmentJobhunterMapper.updateByPrimaryKey(employmentJobhunter);
            return "更新成功";
        }
    }

    @Override
    public EmploymentJobhunter findById(Long id) {
        return employmentJobhunterMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        employmentJobhunterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<EmploymentJobhunterExtend> findAllWithJobhAndEmpl() {
        return employmentJobhunterExtendMapper.selectAllWithJobhAndEmpl();
    }
}
