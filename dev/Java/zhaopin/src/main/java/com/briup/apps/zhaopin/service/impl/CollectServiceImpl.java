package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.Collect;
import com.briup.apps.zhaopin.bean.CollectExample;
import com.briup.apps.zhaopin.bean.extend.CollectExtend;
import com.briup.apps.zhaopin.mapper.CollectMapper;
import com.briup.apps.zhaopin.mapper.extend.CollectExtendMapper;
import com.briup.apps.zhaopin.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: CollectServiceImpl
 * @description: 我的收藏
 * @author: Ricardo
 * @create: 2019/9/30 10:56
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Resource
    private CollectMapper collectMapper;
    @Resource
    private CollectExtendMapper collectExtendMapper;

    @Override
    public List<Collect> findAll() {
        return collectMapper.selectByExample(new CollectExample());
    }

    @Override
    public List<CollectExtend> findAllWithEmpAndJob() {
        return collectExtendMapper.selectAllWithEmpAndJob();
    }

    @Override
    public Collect findById(long id) {
        return collectMapper.selectByPrimaryKey(id);
    }

    @Override
    public String saveOrUpdate(Collect collect) {
        if(collect.getId()==null){
            collectMapper.insert(collect);
            return "添加成功";
        }else{
            collectMapper.updateByPrimaryKey(collect);
            return "修改成功";
        }
    }

    @Override
    public void deleteById(long id) {
        collectMapper.deleteByPrimaryKey(id);
    }
}