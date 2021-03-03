package com.example.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestJspController {

    @RequestMapping("/test") // localhost/test
    public String test() {
        return "test";       // 실제 호출될 /WEB-INF/jsp/test/viewtest2.jsp
    }

}


