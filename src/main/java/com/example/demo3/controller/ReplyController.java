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
    public ResponseEntity<String> reRegist(@RequestBody ReplyVO rvo) {

        ResponseEntity<String> entity = null;
        try {
            rsvc.reWrite(rvo);
            entity = new ResponseEntity<String>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @GetMapping(value = "/all/{boardNo}")
    public ResponseEntity<Map<String, Object>> reRead(@PathVariable("boardNo") int boardNo) {
        ResponseEntity<Map<String, Object>> entity = null;
        try {
            List<ReplyVO> replyList = rsvc.list(boardNo);
            Map<String, Object> reMap = new HashMap<String, Object>();
            reMap.put("replyList", replyList);
            entity = new ResponseEntity<Map<String, Object>>(reMap, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @DeleteMapping(value = "/delete/{replyNo}")
    public ResponseEntity<String> reDelete(@PathVariable("replyNo") int replyNo) {
        ResponseEntity<String> entity = null;
        try {
            rsvc.reDelete(replyNo);
            entity = new ResponseEntity<String>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity; //reentity는 뷰에서 어떠한 액션을 취하기위해 사용한다. if~~~
    }

    @PutMapping(value = "/update/{replyNo}")
    public void reUpdate(@PathVariable("replyNo") int replyNo, @RequestBody ReplyVO rvo){
        rvo.setReplyNo(replyNo);
        rsvc.reUpdate(rvo);
    }
//    public ResponseEntity<String> reUpdate(@PathVariable("replyNo") int replyNo, @RequestBody ReplyVO rvo) {
//        ResponseEntity<String> entity = null;
//        try {
//            rvo.setReplyNo(replyNo);
//            ;
//            rsvc.reUpdate(rvo);
//            entity = new ResponseEntity<String>("Success", HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//        return entity;
//    }

}
