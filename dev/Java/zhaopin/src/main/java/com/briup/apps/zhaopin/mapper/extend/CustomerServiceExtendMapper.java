package com.briup.apps.zhaopin.mapper.extend;

import com.briup.apps.zhaopin.bean.extend.CustomerServiceExtend;

import java.util.List;

public interface CustomerServiceExtendMapper {
    List<CustomerServiceExtend> selectByGender(String gender);
    List<CustomerServiceExtend> selectByStatus(String status);
    List<CustomerServiceExtend> selectByUsername(String username);
}