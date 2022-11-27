package org.example.mysql.config;

import lombok.Value;
import org.springframework.stereotype.Component;

/**
 * @author: liuxuan
 * @date: 2022-11-05 15:56
 **/
@Component//说明这个类被spring接管了，注册到了容器中
public class TestService {
    private String name;

    public String getName() {
        System.out.println("getNAme");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
