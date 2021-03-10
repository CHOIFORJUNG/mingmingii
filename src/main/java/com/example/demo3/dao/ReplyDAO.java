package com.example.demo3.dao;

import com.example.demo3.vo.ReplyVO;

import java.util.List;

public interface ReplyDAO {

    void reInsert(ReplyVO rvo);

    List<ReplyVO> reRead(int boardNo);
}
