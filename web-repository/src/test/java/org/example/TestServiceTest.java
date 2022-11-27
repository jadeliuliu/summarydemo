package org.example;

import org.example.mysql.config.SpringConfig;
import org.example.mysql.config.TestService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: liuxuan
 * @date: 2022-11-05 15:58
 **/
public class TestServiceTest {

    @Test
    public void testStart() {
        //使用配置类，就需要通过AnnotationConfig上下文来获取容器，通过配置类的class加载
        ApplicationContext context =new AnnotationConfigApplicationContext(SpringConfig.class);
        TestService testService = (TestService) context.getBean("testService");
        System.out.println(testService.getName());
    }
}
