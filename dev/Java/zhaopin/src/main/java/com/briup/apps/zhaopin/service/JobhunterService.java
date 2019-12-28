package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.Jobhunter;
import com.briup.apps.zhaopin.bean.extend.JobhunterExtend;

import java.util.List;

public interface JobhunterService {
    List<Jobhunter> findAll();

    String saveOrUpdate(Jobhunter jobhunter);

    Jobhunter findById(Long id);

    void deleteById(Long id);

    List<JobhunterExtend> findByGender(String gender);
    List<JobhunterExtend> findByEducation(String education);
    List<JobhunterExtend> findByUsername(String username);
    List<JobhunterExtend> findByTelephone(String telephone);
    /**
     * @Author CC
     * @Description 快速注册,快速报名接口
     * @Date 2019/9/26 18:11
     * @Param [jobhunter, employmentId]
     * @return java.lang.String
     **/
    
    String quickRegistration(Jobhunter jobhunter,Long employmentId);

}
