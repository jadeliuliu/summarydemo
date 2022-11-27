package org.example.mysql;

import org.example.mysql.domain.StudentDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author: liuxuan
 * @date: 2022-11-05 14:14
 **/
@MapperScan("org.example.mysql.mapper")
public interface StudentDao {

    StudentDO selectById(Long id);

}
