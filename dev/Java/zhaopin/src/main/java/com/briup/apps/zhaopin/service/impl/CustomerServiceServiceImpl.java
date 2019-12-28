package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.CustomerService;
import com.briup.apps.zhaopin.bean.CustomerServiceExample;
import com.briup.apps.zhaopin.bean.extend.CustomerServiceExtend;
import com.briup.apps.zhaopin.mapper.CustomerServiceMapper;
import com.briup.apps.zhaopin.mapper.extend.CustomerServiceExtendMapper;
import com.briup.apps.zhaopin.service.CustomerServiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: CustomerServiceServiceImpl
 * @description: 客服接口的实现类
 * @author: CC
 * @create: 2019/9/19 21:03
 */
@Service
public class CustomerServiceServiceImpl implements CustomerServiceService {
    @Resource
    private CustomerServiceMapper customerServiceMapper;
    @Resource
    private CustomerServiceExtendMapper customerServiceExtendMapper;
    @Override
    public List<CustomerService> findAll() {
        return customerServiceMapper.selectByExample(new CustomerServiceExample());
    }

    @Override
    public String saveOrUpdate(CustomerService customerService) {
        if (customerService.getId()==null){
            customerServiceMapper.insert(customerService);
            return "新增成功";
        }else {
            customerServiceMapper.updateByPrimaryKey(customerService);
            return "更新成功";
        }
    }

    @Override
    public CustomerService findById(Long id) {
        return customerServiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        customerServiceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CustomerServiceExtend> findByGender(String gender) {
        return customerServiceExtendMapper.selectByGender(gender);
    }

    @Override
    public List<CustomerServiceExtend> findByStatus(String status) {
        return customerServiceExtendMapper.selectByStatus(status);
    }

    @Override
    public List<CustomerServiceExtend> findByUsername(String username) {
        return customerServiceExtendMapper.selectByUsername(username);
    }
}
