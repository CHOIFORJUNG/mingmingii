package com.example.demo3.controller;

import com.example.demo3.service.BoardService;
import com.example.demo3.service.ReplyService;
import com.example.demo3.vo.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/replies")
public class ReplyController {


    @Autowired
    private ReplyService rsvc;

    @PostMapping(value = "")
    public void reRegist(ReplyVO rvo){

        rsvc.reWrite(rvo);
    }

    @GetMapping(value = "/replylist")
    public List<ReplyVO> reRead(@RequestParam("boardNo") int boardNo){

        return rsvc.list(boardNo);
    }



}
