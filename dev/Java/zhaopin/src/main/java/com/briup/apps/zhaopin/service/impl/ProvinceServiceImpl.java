package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.Province;
import com.briup.apps.zhaopin.bean.ProvinceExample;
import com.briup.apps.zhaopin.mapper.ProvinceMapper;
import com.briup.apps.zhaopin.service.ProvinceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: ProvinceServiceImpl
 * @description: 省份接口实现类
 * @author: CC
 * @create: 2019/9/26 14:35
 */@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Resource
    private ProvinceMapper provinceMapper;
    @Override
    public List<Province> findAll() {
        return provinceMapper.selectByExample(new ProvinceExample());
    }

    @Override
    public String saveOrUpdate(Province jobhunter) {
        if (jobhunter.getId()==null){
            provinceMapper.insert(jobhunter);
            return "新增成功";
        }else {
            provinceMapper.updateByPrimaryKey(jobhunter);
            return "更新成功";
        }
    }

    @Override
    public Province findById(Long id) {
        return provinceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        provinceMapper.deleteByPrimaryKey(id);
    }
}
