package com.example.demo3.service;

import java.util.List;

import com.example.demo3.dao.BoardDAO;
import com.example.demo3.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private  BoardDAO bdao;


	@Override
	public List<BoardVO> listAll() {
		return bdao.list();
	}

	@Override
	public void write(BoardVO bvo) {
		bdao.insert(bvo);}
}

