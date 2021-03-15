package com.example.demo3.service;

import com.example.demo3.dao.BoardDAO;
import com.example.demo3.vo.ReplyVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReplyService {

     void reWrite(ReplyVO rvoo);
     List<ReplyVO> list(int boardNo);
     void reDelete(int boardNo);
     void reUpdate(ReplyVO rvo);
}
