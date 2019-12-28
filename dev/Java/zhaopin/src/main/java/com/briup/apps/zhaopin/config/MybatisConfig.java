package com.briup.apps.zhaopin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.apps.zhaopin.mapper")
public class MybatisConfig {

}
