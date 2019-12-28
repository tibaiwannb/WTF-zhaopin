package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.Business;
import com.briup.apps.zhaopin.bean.BusinessExample;
import com.briup.apps.zhaopin.bean.extend.BusinessExtend;
import com.briup.apps.zhaopin.mapper.BusinessMapper;
import com.briup.apps.zhaopin.mapper.extend.BusinessExtendMapper;
import com.briup.apps.zhaopin.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: BusinessImpl
 * @description: 商家接口的实现类
 * @author: CC
 * @create: 2019/9/19 20:43
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BusinessMapper businessMapper;
    @Resource
    private BusinessExtendMapper businessExtendMapper;
    @Override
    public List<Business> findAll() {
        return businessMapper.selectByExample(new BusinessExample());
    }

    @Override
    public String saveOrUpdate(Business business) {
        if (business.getId()==null){
            businessMapper.insert(business);
            return "新增成功";
        }else {
            businessMapper.updateByPrimaryKey(business);
            return "更新成功";
        }
    }

    @Override
    public Business findById(Long id) {
        return businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        businessMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<BusinessExtend> findByLocation(String location) {
        return businessExtendMapper.selectByLocation(location);
    }
    @Override
    public List<BusinessExtend> findByProvince(String province) {
        return businessExtendMapper.selectByProvince(province);
    }
    @Override
    public List<BusinessExtend> findByCity(String city) {
        return businessExtendMapper.selectByCity(city);
    }

    @Override
    public List<BusinessExtend> findByIndustry(String industry) {
        return businessExtendMapper.selectByIndustry(industry);
    }

    @Override
    public List<BusinessExtend> findByScale(String scale) {
        return businessExtendMapper.selectByScale(scale);
    }
}
