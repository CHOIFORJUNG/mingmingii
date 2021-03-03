package com.example.demo3.dao;

import java.util.List;

import com.example.demo3.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

public interface BoardDAO {

	public List<BoardVO> list();

	public void insert(BoardVO bvo);
	
}
