package com.briup.apps.zhaopin.mapper.extend;

import com.briup.apps.zhaopin.bean.extend.EmploymentJobhunterExtend;

import java.util.List;

public interface EmploymentJobhunterExtendMapper  {
    List<EmploymentJobhunterExtend> selectAllWithJobhAndEmpl();
}
