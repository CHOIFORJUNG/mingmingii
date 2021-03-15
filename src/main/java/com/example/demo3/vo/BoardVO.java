package com.example.demo3.vo;

import lombok.Data;

@Data
public class BoardVO {

	private Integer boardNo;
	private String boardTitle;
	private String boardContents;
	private String userId;
	private Integer replyCnt;
	private Integer regDate;
	private Integer viewCnt;
	
}
