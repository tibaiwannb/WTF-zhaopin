package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.EmploymentJobhunter;
import com.briup.apps.zhaopin.bean.Jobhunter;
import com.briup.apps.zhaopin.bean.JobhunterExample;
import com.briup.apps.zhaopin.bean.extend.JobhunterExtend;
import com.briup.apps.zhaopin.mapper.EmploymentJobhunterMapper;
import com.briup.apps.zhaopin.mapper.JobhunterMapper;
import com.briup.apps.zhaopin.mapper.extend.JobhunterExtendMapper;
import com.briup.apps.zhaopin.service.JobhunterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: JobhunterServiceImpl
 * @description: 求职者接口的实现类
 * @author: CC
 * @create: 2019/9/19 20:52
 */
@Service
public class JobhunterServiceImpl implements JobhunterService {
    @Resource
    private JobhunterMapper jobhunterMapper;
    @Resource
    private JobhunterExtendMapper jobhunterExtendMapper;
    @Resource
    private EmploymentJobhunterMapper employmentJobhunterMapper;
    @Override
    public List<Jobhunter> findAll() {
        return jobhunterMapper.selectByExample(new JobhunterExample());
    }

    @Override
    public String saveOrUpdate(Jobhunter jobhunter) {
        // 判断是新增还是修改
        if (jobhunter.getId()==null){
            jobhunterMapper.insert(jobhunter);
            return "新增成功";
        }else {
            jobhunterMapper.updateByPrimaryKey(jobhunter);
            return "更新成功";
        }
    }

    @Override
    public String quickRegistration(Jobhunter jobhunter, Long employmentId) {
            // 获取输入的手机号
            String phone = jobhunter.getTelephone();
            // 在求职者表里查询此手机号是否存在
            if(findByTelephone(phone).size()==0){
                // 该手机号未注册,先添加用户
                jobhunterExtendMapper.insertextend(jobhunter);
                // 然后添加报名信息
                EmploymentJobhunter employmentJobhunter = new EmploymentJobhunter();
                employmentJobhunter.setEmploymentId(employmentId);
                employmentJobhunter.setJobhunterId(jobhunter.getId());
                employmentJobhunterMapper.insert(employmentJobhunter);
                return "新增用户&报名成功";
            }else{
                // 该手机号已注册,根据手机号查询用户ID ;
                // 添加报名信息
                // JSON a = JSONObject.fromObject(findByTelephone(phone).get(0));
                Jobhunter b = findByTelephone(phone).get(0); // 获取用户ID
                EmploymentJobhunter employmentJobhunter = new EmploymentJobhunter();
                employmentJobhunter.setEmploymentId(employmentId);
                employmentJobhunter.setJobhunterId(b.getId());
                employmentJobhunterMapper.insert(employmentJobhunter);
                return "新增用户失败,该手机号已注册&报名成功";
            }
    }

    @Override
    public List<JobhunterExtend> findByTelephone(String telephone) {
        return jobhunterExtendMapper.selectByTelephone(telephone);
    }

    @Override
    public Jobhunter findById(Long id) {
        return jobhunterMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        jobhunterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<JobhunterExtend> findByGender(String gender) {
        return jobhunterExtendMapper.selectByGender(gender);
    }

    @Override
    public List<JobhunterExtend> findByEducation(String education) {
        return jobhunterExtendMapper.selectByEducation(education);
    }

    @Override
    public List<JobhunterExtend> findByUsername(String username) {
        return jobhunterExtendMapper.selectByUsername(username);
    }
}
