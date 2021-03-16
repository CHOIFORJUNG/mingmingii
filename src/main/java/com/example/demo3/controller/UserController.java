package com.example.demo3.controller;

import com.example.demo3.service.UserService;
import com.example.demo3.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    UserService usvc;

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String registGET (){
        return "thymeleaf/regist";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String registPOST (UserVO uvo, RedirectAttributes reAtt) {

        usvc.join(uvo);
        reAtt.addFlashAttribute("result", "Success");
        return "redirect:/list";
    }
}
