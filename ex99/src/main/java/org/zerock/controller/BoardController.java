package org.project.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.project.domain.BoardAttachVO;
import org.project.domain.BoardVO;
import org.project.domain.Criteria;
import org.project.domain.PageDTO;
import org.project.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {

	@Autowired
	BoardService service;
	
	
	@GetMapping("/list")
	public void list(Criteria cri,Model model) {	
		
		model.addAttribute("list",service.getList(cri));
		
		int total=service.getTotal(cri);
		
		PageDTO page=new PageDTO(cri,total);
		
		model.addAttribute("pageMaker",page);
	}
	
	@GetMapping("/list_f")
	public void list1(Criteria cri,Model model) {	
		
		model.addAttribute("list",service.getList_f(cri));
		
		int total=service.getTotal_f(cri);
		
		PageDTO page=new PageDTO(cri,total);
		
		model.addAttribute("pageMaker",page);
	}
	
	@GetMapping("/list_h")
	public void list_h(Criteria cri,Model model) {	
		
		model.addAttribute("list",service.getList_h(cri));
		
		int total=service.getTotal_h(cri);
		
		PageDTO page=new PageDTO(cri,total);
		
		model.addAttribute("pageMaker",page);
	}
	
	
	@GetMapping("/list_i")
	public void list_i(Criteria cri,Model model) {	
		
		model.addAttribute("list",service.getList_i(cri));
		
		int total=service.getTotal_i(cri);
		
		PageDTO page=new PageDTO(cri,total);
		
		model.addAttribute("pageMaker",page);
	}
	
	
	
	@GetMapping("/register")
	public void register() {
		System.out.println("register get");
	}
	
	@PostMapping("/register")
	public String register(BoardVO board,RedirectAttributes rttr) {
		System.out.println("register");
		
		if(board.getAttachList()!=null) {
			board.getAttachList().forEach(attach->log.info(attach));
		}
		
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","modify"})
	public void get(Long bno,@ModelAttribute("cri") Criteria cri,Model model) {
		model.addAttribute("board",service.get(bno));
	}
	
	
	  @PostMapping("/modify") 
	  public String modify(BoardVO board,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
	  System.out.println("modify");
	  
	  if(service.modify(board)) { rttr.addFlashAttribute("result","success"); }
	  rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
	  
	  return "redirect:/board/list"; }
	  
	  @PostMapping("/remove") 
	  public String remove(Long bno,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) { 
		  System.out.println("remove");
	  
		  List<BoardAttachVO> attachList=service.getAttachList(bno);
		  		 
	  if(service.remove(bno)) { deleteFiles(attachList); rttr.addFlashAttribute("result","success"); }
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
	  
	  return "redirect:/board/list"+cri.getListLink(); }
	 
	  
	  @GetMapping(value="/getAttachList", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	  @ResponseBody
	  public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		  
		  return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);
		  
	  }
	
	  
	  private void deleteFiles(List<BoardAttachVO> attachList) {
		  if(attachList == null || attachList.size()==0) {
			  return;
		  }
		  log.info("delete attach files............");
		  log.info(attachList);
		  
		  attachList.forEach(attach->{
			  try {
				  Path file=Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\"+attach.getUuid()+"_"+attach.getFileName());
				  Files.deleteIfExists(file);
				  if(Files.probeContentType(file).startsWith("image")) {
					  Path thumbNail=Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\s_"+attach.getUuid()+"_"+attach.getFileName());
					  Files.delete(thumbNail);
				  }
			  }catch(Exception e) {
				  log.error("delete file error"+e.getMessage());
			  }
		  });
	  }
}
