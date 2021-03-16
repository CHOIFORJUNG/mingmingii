package com.example.demo3.dao;

import com.example.demo3.vo.LoginDTO;
import com.example.demo3.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    SqlSession sqlSession;

    @Override
    public void regist(UserVO uvo){
        sqlSession.insert("regist", uvo);
    }

    @Override
    public UserVO login(LoginDTO ldto) {
        return sqlSession.selectOne("login", ldto);
    }
}
