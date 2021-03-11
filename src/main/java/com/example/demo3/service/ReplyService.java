package com.example.demo3.service;

import com.example.demo3.vo.ReplyVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReplyService {

     void reWrite(ReplyVO rvo);
     List<ReplyVO> list(int boardNo);
     void reDelete(int boardNo);
}
