package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.City;
import com.briup.apps.zhaopin.bean.CityExample;
import com.briup.apps.zhaopin.bean.extend.CityExtend;
import com.briup.apps.zhaopin.mapper.CityMapper;
import com.briup.apps.zhaopin.mapper.extend.CityExtendMapper;
import com.briup.apps.zhaopin.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: CityServiceImpl
 * @description: 城市接口实现类
 * @author: CC
 * @create: 2019/9/21 9:11
 */
@Service
public class CityServiceImpl implements CityService {
    @Resource
    private CityMapper cityMapper;

    @Resource
    private CityExtendMapper cityExtendMapper;
    @Override
    public List<City> findAll() {
        return cityMapper.selectByExample(new CityExample());
    }

    @Override
    public String saveOrUpdate(City city) {
        if (city.getId()==null){
            cityMapper.insert(city);
            return "新增成功";
        }else {
            cityMapper.updateByPrimaryKey(city);
            return "更新成功";
        }
    }

    @Override
    public City findById(Long id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        cityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CityExtend> findByProvinceId(Long provinceid) {
        return cityExtendMapper.selectByProvinceID(provinceid);
    }

}
