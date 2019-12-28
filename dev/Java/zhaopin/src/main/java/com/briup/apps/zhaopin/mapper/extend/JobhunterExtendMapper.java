package com.briup.apps.zhaopin.mapper.extend;

import com.briup.apps.zhaopin.bean.Jobhunter;
import com.briup.apps.zhaopin.bean.extend.JobhunterExtend;

import java.util.List;

public interface JobhunterExtendMapper {
    List<JobhunterExtend> selectByGender(String gender);
    List<JobhunterExtend> selectByEducation(String education);
    List<JobhunterExtend> selectByUsername(String username);
    List<JobhunterExtend> selectByTelephone(String telephone);


    int insertextend(Jobhunter record);


}
