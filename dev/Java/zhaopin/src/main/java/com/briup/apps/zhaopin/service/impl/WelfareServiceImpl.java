package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.Welfare;
import com.briup.apps.zhaopin.bean.WelfareExample;
import com.briup.apps.zhaopin.mapper.WelfareMapper;
import com.briup.apps.zhaopin.service.WelfareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: WelfareServiceImpl
 * @description: 福利接口实现类
 * @author: CC
 * @create: 2019/9/21 9:12
 */
@Service
public class WelfareServiceImpl implements WelfareService {
    @Resource
    private WelfareMapper welfareMapper;
    @Override
    public List<Welfare> findAll() {
        return welfareMapper.selectByExample(new WelfareExample());
    }

    @Override
    public String saveOrUpdate(Welfare welfare) {
        if (welfare.getId()==null){
            welfareMapper.insert(welfare);
            return "新增成功";
        }else {
            welfareMapper.updateByPrimaryKey(welfare);
            return "更新成功";
        }
    }

    @Override
    public Welfare findById(Long id) {
        return welfareMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        welfareMapper.deleteByPrimaryKey(id);
    }
}
