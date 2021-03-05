package com.example.demo3.dao;

import java.util.List;

import com.example.demo3.vo.BoardVO;

public interface BoardDAO {

	 List<BoardVO> list();

	 void insert(BoardVO bvo);

	 BoardVO read(Integer boardNo);

	 void delete(Integer boardNo);
	
}
