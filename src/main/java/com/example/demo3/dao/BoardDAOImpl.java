package com.example.demo3.dao;

import com.example.demo3.vo.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    SqlSession sqlSession;

    @Autowired
    private static String namespace ="com.example.demo3.vo.BoardVO";

    @Override
    public List<BoardVO> list(){
        return sqlSession.selectList("list");
    };

    @Override
    public void insert(BoardVO bvo){
        sqlSession.insert("namespace", bvo);
    }
}
