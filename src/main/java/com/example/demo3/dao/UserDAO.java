package com.example.demo3.dao;

import com.example.demo3.vo.LoginDTO;
import com.example.demo3.vo.UserVO;

public interface UserDAO {

    void regist(UserVO uvo);

    UserVO login(LoginDTO ldto);
}
