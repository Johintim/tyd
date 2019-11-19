package com.briup.apps.tyd.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.apps.tyd.dao")
public class MybatisConfig {

}
