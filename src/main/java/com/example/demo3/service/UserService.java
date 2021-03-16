package com.example.demo3.service;

import com.example.demo3.vo.LoginDTO;
import com.example.demo3.vo.UserVO;
import org.springframework.stereotype.Service;

public interface UserService {

     void join(UserVO uvo);

     UserVO loginOK(LoginDTO ldto);
}
