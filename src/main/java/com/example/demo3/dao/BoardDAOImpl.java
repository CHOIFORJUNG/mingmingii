package com.example.demo3.dao;

import com.example.demo3.vo.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<BoardVO> list(){
        return sqlSession.selectList("list");
    }

    @Override
    public void insert(BoardVO bvo){
        sqlSession.insert("insert", bvo);
    }

    @Override
    public BoardVO read(Integer boardNo){
        return sqlSession.selectOne("read", boardNo);}

    @Override
    public void delete(Integer boardNo){
        sqlSession.delete("delete", boardNo);
    }

    @Override
    public void update(BoardVO bvo) {
        sqlSession.update("update", bvo);
    }

    @Override
    public void updateReplyCnt(Integer boardNo, int amount) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("boardNo", boardNo);
        paramMap.put("amount", amount);

        sqlSession.update("updateReplyCnt", paramMap);
    }

    @Override
    public void updateViewCnt(Integer boardNo) {
        sqlSession.update("updateViewCnt", boardNo);
    }
}
