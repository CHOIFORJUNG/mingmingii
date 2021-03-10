package com.example.demo3.service;

import com.example.demo3.dao.ReplyDAO;
import com.example.demo3.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyDAO rdao;

    @Autowired
    public ReplyServiceImpl(ReplyDAO rdao){
        this.rdao = rdao;
    }

    @Override
    public void reWrite(ReplyVO rvo){
        rdao.reInsert(rvo);
    }

    @Override
    public List<ReplyVO> list(int boardNo) {
        return rdao.reRead(boardNo);
    }
}
