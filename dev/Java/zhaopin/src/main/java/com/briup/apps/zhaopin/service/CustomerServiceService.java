package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.CustomerService;
import com.briup.apps.zhaopin.bean.extend.CustomerServiceExtend;

import java.util.List;

public interface CustomerServiceService {
    List<CustomerService> findAll();

    String saveOrUpdate(CustomerService customerService);

    CustomerService findById(Long id);

    void deleteById(Long id);

    List<CustomerServiceExtend> findByGender(String gender);
    List<CustomerServiceExtend> findByStatus(String status);
    List<CustomerServiceExtend> findByUsername(String username);
}
