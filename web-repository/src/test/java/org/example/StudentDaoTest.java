package org.example;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mysql.StudentDao;
import org.example.mysql.config.SpringConfig;
import org.example.mysql.config.TestService;
import org.example.mysql.domain.StudentDO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.InputStream;

/**
 * @author: liuxuan
 * @date: 2022-11-05 17:39
 **/
public class StudentDaoTest {

    @Test
    public void testSelectById() {

        ApplicationContext context =new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        StudentDO studentDO = studentDao.selectById(1L);
        System.out.println(studentDO); 
    }
}
