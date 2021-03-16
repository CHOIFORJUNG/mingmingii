package com.example.demo3.service;

import com.example.demo3.dao.UserDAO;
import com.example.demo3.vo.LoginDTO;
import com.example.demo3.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO udao;

    @Override
    public void join(UserVO uvo){
        udao.regist(uvo);
    }

    @Override
    public UserVO loginOK(LoginDTO ldto) {
        return udao.login(ldto);
    }
}
