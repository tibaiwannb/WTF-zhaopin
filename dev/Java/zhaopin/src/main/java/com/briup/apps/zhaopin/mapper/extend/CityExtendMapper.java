package com.briup.apps.zhaopin.mapper.extend;

import com.briup.apps.zhaopin.bean.extend.CityExtend;

import java.util.List;

public interface CityExtendMapper {
    List<CityExtend> selectByProvinceID(Long provinceid);

}