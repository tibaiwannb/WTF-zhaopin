package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.Browse;
import com.briup.apps.zhaopin.bean.BrowseExample;
import com.briup.apps.zhaopin.bean.extend.BrowseExtend;
import com.briup.apps.zhaopin.mapper.BrowseMapper;
import com.briup.apps.zhaopin.mapper.extend.BrowseExtendMapper;
import com.briup.apps.zhaopin.service.BrowseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrowseServiceImpl implements BrowseService {

    @Resource
    private BrowseMapper browseMapper;
    @Resource
    private BrowseExtendMapper browseExtendMapper;

    @Override
    public List<Browse> findAll() {
        return browseMapper.selectByExample(new BrowseExample());
    }

    @Override
    public List<BrowseExtend> findAllWithEmpAndJob() {
        return browseExtendMapper.selectAllWithEmpAndJob();
    }

    @Override
    public String saveOrUpdate(Browse browse) {
        if(browse.getId()==null){
            browseMapper.insert(browse);
            return "添加成功";
        }else {
            browseMapper.updateByPrimaryKey(browse);
            return "修改成功";
        }
    }

    @Override
    public Browse findById(Long id) {
        return browseMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        browseMapper.deleteByPrimaryKey(id);
    }
}
