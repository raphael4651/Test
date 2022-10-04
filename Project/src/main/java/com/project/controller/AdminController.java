package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.UserDto;
import com.project.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;
	
	@GetMapping("/adminPage")
	public void admin() {
		
	}
	@GetMapping(value="/userList",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<UserDto> userList(){
		//List<UserOrderDto> list = orderService.selectUserOrder("admin");
		List<UserDto> list = userService.getUserList();
		return list;
	}
	
	
}
