package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.Collect;
import com.briup.apps.zhaopin.bean.extend.CollectExtend;

import java.util.List;

public interface CollectService {
    List<Collect> findAll();
    List<CollectExtend> findAllWithEmpAndJob();
    Collect findById(long id);
    String saveOrUpdate(Collect collect);
    void deleteById(long id);
}
