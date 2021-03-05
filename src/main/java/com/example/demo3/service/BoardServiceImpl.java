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
		bdao.insert(bvo);
	}

	@Override
	public BoardVO reading(Integer boardNo) { //받는쪽 파라미터()이니 타입을 써주고
		return bdao.read(boardNo);			//호출하는쪽 파라미터()이니 값만써준다.
		}

	@Override
	public void delete(Integer boardNo){
		bdao.delete(boardNo);
	}

	@Override
	public void modify(BoardVO bvo) {
		bdao.update(bvo);
	}
}

