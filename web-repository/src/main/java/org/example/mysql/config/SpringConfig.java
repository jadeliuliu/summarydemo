package org.example.mysql.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: liuxuan
 * @date: 2022-11-05 15:44
 **/
@Configuration
@ComponentScan(basePackages = {"org.example"})
@ImportResource("classpath:spring-mybatis.xml") //导入xml配置项
public class SpringConfig {
}
