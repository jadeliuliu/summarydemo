package org.example.annotation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

/**
 * @author: liuxuan
 * @date: 2022-04-29 23:01
 **/
public class PatternTest {

    public static void main(String[] args) {
        StudentVO student = new StudentVO();
        student.setName("111");
        System.out.println(student.getName());
    }

    @Getter
    @Setter
    public static class StudentVO{
        @Pattern(regexp = "^[A-Za-z]+$", message = "只能字母")
        private String name;
        private Long age;
    }
}
