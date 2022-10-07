package org.project.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.project.domain.BoardAttachVO;
import org.project.domain.BoardVO;
import org.project.domain.Criteria;
import org.project.domain.PageDTO;
import org.project.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService service;
		
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
	@PreAuthorize("isAuthenticated()")
	public void register() {
		System.out.println("register get");
	}
	
	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String register(BoardVO board,RedirectAttributes rttr) {
		System.out.println("register");
		
		if(board.getAttachList()!=null) {
			board.getAttachList().forEach(attach->log.info(attach));
		}
		
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(Long bno,@ModelAttribute("cri") Criteria cri,Model model) {
		System.out.println("get or modify");
		
		model.addAttribute("board",service.get(bno));
	}
	
	@PreAuthorize("principal.username == #board.writer")
	@PostMapping("/modify")	
	public String modify(BoardVO board,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		System.out.println("controller modify:"+board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PreAuthorize("principal.username == #writer")
	@PostMapping("/remove")	
	public String remove(@RequestParam("bno") Long bno,@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr,String writer) {
		System.out.println("삭제 번호:"+bno);
		
		List<BoardAttachVO> attachList=service.getAttachList(bno);
		
		if(service.remove(bno)) {
			//첨부파일 삭제
			deleteFiles(attachList);
			
			rttr.addFlashAttribute("result","success");
		}
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/board/list";
	}	
	
	@GetMapping(value="/getAttachList",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		System.out.println("getAttachList:"+bno);
		
		return new ResponseEntity<>(service.getAttachList(bno),HttpStatus.OK);
	}
	
	private void deleteFiles(List<BoardAttachVO> attachList) {
		
		if(attachList==null || attachList.size()==0) {
			return;
		}
		
		System.out.println("첨부 파일 삭제.....");
		System.out.println(attachList);
		
		attachList.forEach(attach->{
			try {
				Path file=Paths.get("c:\\upload\\"+attach.getUploadPath()+"\\"
					+attach.getUuid()+"_"+attach.getFileName());
				
				Files.deleteIfExists(file);
				
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail=Paths.get("c:\\upload\\"+attach.getUploadPath()+"\\s_"
							+attach.getUuid()+"_"+attach.getFileName());
					
					Files.delete(thumbNail);
				}				
			}catch(Exception e) {
				System.out.println("파일 삭제 에러:"+e.getMessage());
			}
		});
	}
}
