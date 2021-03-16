package com.example.demo3.controller;

import com.example.demo3.service.UserService;
import com.example.demo3.vo.LoginDTO;
import com.example.demo3.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@RequestMapping(value = "login")
@Controller
public class LoginController {

    @Autowired
    UserService usvc;

    @RequestMapping(value = "/logini" ,method = RequestMethod.GET)
    public String loginGET (@ModelAttribute("ldto") LoginDTO ldto){

        return "/thymeleaf/logini";
    }

    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    public void loginPOST (LoginDTO ldto, HttpSession httpSession, Model model){

        UserVO uvo = usvc.loginOK(ldto);
        if (uvo == null || ldto.getUserPw() != uvo.getUserPw()){
            return;
        }
        model.addAttribute("user", uvo);
    }
}
