package com.example.demo3.dao;

import com.example.demo3.vo.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Namespace;
import java.util.List;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

    private static String Namespace = "com.example.demo3.mapper.replyMapper";

    private static SqlSession sqlSession;

    @Autowired
    public ReplyDAOImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public void reInsert(ReplyVO rvo) {
        sqlSession.insert("reInsert", rvo);
    }

    @Override
    public List<ReplyVO> reRead(int boardNo){
        return sqlSession.selectList("reRead", boardNo);
    }
}
