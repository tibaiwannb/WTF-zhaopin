package com.briup.apps.zhaopin.service;

import com.briup.apps.zhaopin.bean.Message;

import java.util.List;

public interface MessageService {
    List<com.briup.apps.zhaopin.bean.Message> findAll();

    String saveOrUpdate(Message message);

    Message findById(Long id);

    void deleteById(Long id);
}
