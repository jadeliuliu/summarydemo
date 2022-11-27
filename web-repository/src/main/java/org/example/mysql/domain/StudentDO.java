package org.example.mysql.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

/**
 * @author: liuxuan
 * @date: 2022-11-05 14:41
 **/
@Getter
@Setter
@ToString
public class StudentDO {

    private String name;

    private Long mId;
}
