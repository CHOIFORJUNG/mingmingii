package com.example.demo3.controller;

import com.example.demo3.service.BoardService;
import com.example.demo3.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

	@Autowired
	 private BoardService bsvc;

	@GetMapping(value = "/list")
	public String list(Model model) {

//		return bsvc.listAll();
		model.addAttribute("list", bsvc.listAll());  //RestController return뒤에는 날려줄 값을 넣어주는거야.
		System.out.println("list");
		return "thymeleaf/list";
	}

	@GetMapping(value = "/insert")
	public void insertGET(BoardVO bvo){
	}

	@PostMapping(value = "/insert")
	public String insertPOST(BoardVO bvo, Model model){

		bsvc.write(bvo);
		model.addAttribute("result", "success");
		return "redirect:/list/";
	}
}


