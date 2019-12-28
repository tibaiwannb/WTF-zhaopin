package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.Business;
import com.briup.apps.zhaopin.bean.extend.BusinessExtend;

import java.util.List;

public interface BusinessService {
    List<Business> findAll();

    String saveOrUpdate(Business business);

    Business findById(Long id);

    void deleteById(Long id);

    List<BusinessExtend> findByLocation(String location);
    List<BusinessExtend> findByProvince(String province);
    List<BusinessExtend> findByCity(String city);
    List<BusinessExtend> findByIndustry(String industry);
    List<BusinessExtend> findByScale(String scale);

}
