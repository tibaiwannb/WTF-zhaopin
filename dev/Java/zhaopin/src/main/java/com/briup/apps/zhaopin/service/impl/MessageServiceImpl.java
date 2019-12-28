package com.briup.apps.zhaopin.service.impl;

import com.briup.apps.zhaopin.bean.Message;
import com.briup.apps.zhaopin.bean.MessageExample;
import com.briup.apps.zhaopin.mapper.MessageMapper;
import com.briup.apps.zhaopin.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: MessagesServiceImpl
 * @description: 消息通知接口实现类
 * @author: CC
 * @create: 2019/9/21 9:15
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<Message> findAll() {
        return messageMapper.selectByExample(new MessageExample());
    }

    @Override
    public String saveOrUpdate(Message message) {
        if (message.getId() == null) {
            messageMapper.insert(message);
            return "新增成功";
        } else {
            messageMapper.updateByPrimaryKey(message);
            return "更新成功";
        }
    }

    @Override
    public Message findById(Long id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Long id) {
        messageMapper.deleteByPrimaryKey(id);
    }
}