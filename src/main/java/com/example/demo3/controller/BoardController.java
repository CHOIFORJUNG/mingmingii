package com.example.demo3.controller;

import com.example.demo3.service.BoardService;
import com.example.demo3.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String insertGET() {
		return "thymeleaf/insert";
	}

	@PostMapping(value = "/insert")
	public String insertPOST(@ModelAttribute(name="bvo") BoardVO bvo) {
		bsvc.write(bvo);
		return "redirect:/list";
	}

	@GetMapping(value = "/read")
	public String reading(@RequestParam("boardNo") int boardNo, Model model){
		model.addAttribute("BoardVO", bsvc.reading(boardNo));
		return "thymeleaf/read";
	}

	@RequestMapping(value = "/delete", method={RequestMethod.GET, RequestMethod.POST})
	public String delete(int boardNo, RedirectAttributes reAttr){
		bsvc.delete(boardNo);
		reAttr.addFlashAttribute("result", "success");
		return "redirect:/list";
		//form 형식의 문서를 작성 후, 서버로 보내면(POST 방식) 곧이어 다른 페이지로 리다이렉트 한다.
	}

	@RequestMapping(value = "/update", method = {RequestMethod.GET})
		public String modifyGET(@RequestParam("boardNo") int boardNo, Model model){
			model.addAttribute("bvo", bsvc.reading(boardNo));
			return "thymeleaf/update";	//생략가능하다.
		}

	@RequestMapping(value = "/update", method = {RequestMethod.POST})
		public String modifyPOST(RedirectAttributes reAttr, BoardVO bvo){
			bsvc.modify(bvo);
			reAttr.addFlashAttribute("result","modifyOK");
			return "redirect:/list";
	} //https://oolaf.tistory.com/105
}
