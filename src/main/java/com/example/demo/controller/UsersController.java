package com.example.demo.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.UsersRepository;
import com.example.demo.service.JoinService;
import com.example.demo.service.LoginService;

@Controller
public class UsersController{
	
	@Autowired
	private UsersRepository	usersRepository;
	
	@Autowired
	private JoinService joinService;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value="/joinRequest")
	public String joinRequest(@RequestParam Map<String,String>paramMap) {
		String userId = paramMap.get("userId");
		String userPw = paramMap.get("userPw");
		String userName = paramMap.get("userName");
		 
		String page = joinService.joinUser(userId,userPw,userName);
		return page;
	}
	
	@PostMapping(value="/loginRequest")
	public String loginRequest(@RequestParam Map<String,String> paramMap) {
		String userId = paramMap.get("userId");
		String userPw = paramMap.get("userPw");
		
		String page = loginService.login(userId,userPw);
		
		return page;
	}
}
