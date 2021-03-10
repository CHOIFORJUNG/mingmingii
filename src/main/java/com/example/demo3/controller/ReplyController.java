package com.example.demo3.controller;

import com.example.demo3.service.BoardService;
import com.example.demo3.service.ReplyService;
import com.example.demo3.vo.ReplyVO;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/replies")
public class ReplyController {


    @Autowired
    private ReplyService rsvc;

    @PostMapping(value = "")
    public void reRegist(ReplyVO rvo){

        rsvc.reWrite(rvo);
    }

    @GetMapping(value = "/all/{boardNo}")
    public ResponseEntity<Map<String, Object>> reRead(@PathVariable("boardNo") int boardNo){
        ResponseEntity<Map<String, Object>> entity = null;
        try {
             List<ReplyVO> replyList = rsvc.list(boardNo);
            Map<String, Object> reMap = new HashMap<String, Object>();
            reMap.put("replyList", replyList);
            entity = new ResponseEntity<Map<String, Object>>(reMap, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }



}
