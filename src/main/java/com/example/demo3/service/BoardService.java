package com.example.demo3.service;

import com.example.demo3.vo.BoardVO;

import java.util.List;

public interface BoardService {

     List<BoardVO> listAll();
     void write(BoardVO bvo);
     BoardVO reading(Integer boardNo);
     void delete(Integer boardNo);
}
