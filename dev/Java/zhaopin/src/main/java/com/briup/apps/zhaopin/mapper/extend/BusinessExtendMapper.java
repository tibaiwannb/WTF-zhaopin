package com.briup.apps.zhaopin.mapper.extend;

import com.briup.apps.zhaopin.bean.extend.BusinessExtend;

import java.util.List;

public interface BusinessExtendMapper {
    List<BusinessExtend> selectByLocation(String location);
    List<BusinessExtend> selectByProvince(String province);
    List<BusinessExtend> selectByCity(String city);
    List<BusinessExtend> selectByIndustry(String industry);
    List<BusinessExtend> selectByScale(String scale);
}
