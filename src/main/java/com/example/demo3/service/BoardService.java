package com.example.demo3.service;

import com.example.demo3.vo.BoardVO;

import java.util.List;

public interface BoardService {

    public List<BoardVO> listAll();
    public void write(BoardVO bvo);
}
