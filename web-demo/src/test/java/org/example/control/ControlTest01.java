package org.example.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuxuan
 * @date: 2022-04-30 10:40
 **/
@RestController
@RequestMapping("/home")
public class ControlTest01 {
    @RequestMapping("/")
    String get() {
        //mapped to hostname:port/home/
        return "go to home";
    }
    @RequestMapping("/index")
    String index() {
        //mapped to hostname:port/home/index/
        return "go to index";
    }
}

