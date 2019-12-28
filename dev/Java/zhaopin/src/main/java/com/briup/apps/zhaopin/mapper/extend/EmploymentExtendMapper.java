package com.briup.apps.zhaopin.mapper.extend;

import com.briup.apps.zhaopin.bean.extend.EmploymentExtend;

import java.util.List;

public interface EmploymentExtendMapper {
    List<EmploymentExtend> selectByJob(String job);
    List<EmploymentExtend> selectByTitle(String title);
    List<EmploymentExtend> selectByCity(String city);
    List<EmploymentExtend> selectByWelfare(String welfare);
}