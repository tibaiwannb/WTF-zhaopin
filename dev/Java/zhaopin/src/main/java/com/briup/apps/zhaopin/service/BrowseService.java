package com.briup.apps.zhaopin.service;


import com.briup.apps.zhaopin.bean.Browse;
import com.briup.apps.zhaopin.bean.extend.BrowseExtend;

import java.util.List;

public interface BrowseService {
    List<Browse> findAll();
    List<BrowseExtend> findAllWithEmpAndJob();
    String saveOrUpdate(Browse browse);
    Browse findById(Long id);
    void deleteById(Long id);
}
