package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService service;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		System.out.println("list");
//		
//		model.addAttribute("list",service.getList());
//	}
	
	@GetMapping("/list")
	public void list(Criteria cri,Model model) {	
		
		model.addAttribute("list",service.getList(cri));
		
		int total=service.getTotal(cri);
		
		PageDTO page=new PageDTO(cri,total);
		
		System.out.println("pageNum:"+cri.getPageNum());
		System.out.println("amount:"+cri.getAmount());
		System.out.println("type:"+cri.getType());
		System.out.println("keyword:"+cri.getKeyword());
		
		System.out.println("startPage:"+page.getStartPage());
		System.out.println("endPage:"+page.getEndPage());
		
		model.addAttribute("pageMaker",page);
	}
	
	@GetMapping("/register")
	public void register() {
		System.out.println("register get");
	}
	
	@PostMapping("/register")
	public String register(BoardVO board,RedirectAttributes rttr) {
		System.out.println("register");
		
		service.register(board);
		
		rttr.addFlashAttribute("result",board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(Long bno,@ModelAttribute("cri") Criteria cri,Model model) {
		System.out.println("get or modify");
		
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		System.out.println("modify");
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		System.out.println("remove");
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/board/list";
	}	
	
//	@PostMapping("/modify")
//	public String modify(BoardVO board,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
//		System.out.println("modify");
//		
//		if(service.modify(board)) {
//			rttr.addFlashAttribute("result","success");
//		}
//		
//		return "redirect:/board/list"+cri.getListLink();
//	}
//	
//	@PostMapping("/remove")
//	public String remove(Long bno,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
//		System.out.println("remove");
//		
//		if(service.remove(bno)) {
//			rttr.addFlashAttribute("result","success");
//		}
//				
//		return "redirect:/board/list"+cri.getListLink();
//	}
		
}
