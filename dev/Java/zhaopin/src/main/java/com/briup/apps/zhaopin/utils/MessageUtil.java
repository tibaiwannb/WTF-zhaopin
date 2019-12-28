package com.briup.apps.zhaopin.utils;

import java.util.Date;

/**
 * @program: CardServiceImpl
 * @description: 统一消息返回方法
 * @author: CC
 * @create: 2019/4/30 16:37
 */
public class MessageUtil {
    public static Message success(String msg){
        Message message =new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setData(null);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    public static Message success(String msg,Object date){
        Message message =new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setData(date);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    public static Message success(Object date){
        Message message =new Message();
        message.setStatus(200);
        message.setMessage("success");
        message.setData(date);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    public static Message error(String msg){
        Message message =new Message();
        message.setStatus(500);
        message.setMessage(msg);
        message.setData(null);
        message.setTimestamp(new Date().getTime());
        return message;
    }
}
