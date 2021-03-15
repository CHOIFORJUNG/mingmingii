package com.example.demo3.service;

import com.example.demo3.dao.BoardDAO;
import com.example.demo3.dao.ReplyDAO;
import com.example.demo3.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyDAO rdao;
    private final BoardDAO bdao;

    @Autowired
    public ReplyServiceImpl(ReplyDAO rdao, BoardDAO bdao){
        this.rdao = rdao;
        this.bdao = bdao;
    }

    @Transactional
    @Override
    public void reWrite(ReplyVO rvo){
        rdao.reInsert(rvo);
        bdao.updateReplyCnt(rvo.getBoardNo(), 1);
    }

    @Override
    public List<ReplyVO> list(int boardNo) {
        return rdao.reRead(boardNo);
    }

    @Transactional
    @Override
    public void reDelete(int replyNo) {
        int boardNo = rdao.getBoardNo(replyNo);
        rdao.reDelete(replyNo);
        bdao.updateReplyCnt(boardNo, -1);
    }

    @Override
    public void reUpdate(ReplyVO rvo) {
        rdao.reUpdate(rvo);
    }
}
