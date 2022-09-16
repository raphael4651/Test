package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.model.BoardVO;
import com.project.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//게시판 목록 페이지 접속
	@GetMapping("/list")
	public void boardListGet(Model model) {
		System.out.println("게시판 목록 ");
		
		model.addAttribute("list", boardService.getList());
	}
	
	//게시판등록 페이지 접속
	@GetMapping("/insert") 
	public void BoardInsertGet() {
		System.out.println("게시판 등록"); 
	}
		
	//게시판등록
	@PostMapping("/insert")
	public String BoardInsertPost(BoardVO board, RedirectAttributes rttr) {
		System.out.println("게시판 등록 : " + board); 
		
		boardService.insert(board);
		
		rttr.addFlashAttribute("result", "게시글 등록 성공");
		
		return "redirect:/board/list";
	}
	
	//게시판 조회
	@GetMapping("/get")
	public void boardGetPageGET(int tradeBno, Model model) {
		model.addAttribute("pageInfo", boardService.getPage(tradeBno));
	}
	 
	//수정 페이지 이동
	@GetMapping("/modify")
	public void boardModifyGET(int tradeBno, Model model) {
		model.addAttribute("pageInfo", boardService.getPage(tradeBno));
	}
	
	//게시판 수정
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
		boardService.modify(board);
		
		rttr.addFlashAttribute("result", "수정 성공");
		
		return "redirect:/board/list";
	}
}









