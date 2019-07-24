package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	
	@Autowired
	private HttpSession session;
	 @GetMapping("/")
	  public String index() {
		 return "index";
	 }
	 @GetMapping("/joinPage")
	 public String joinPage() {
		 return "join";
	 }
	 @GetMapping("/loginPage")
	 public String loginPage() {
		 return "login";
	 }
	 
	 @GetMapping("/logout")
	 public String logout() {
		 session.invalidate();
		 return "index";
	 }
	
	 @GetMapping("/freeboardWritePage")
	 public String freeboardWritePage() {
		 return "freeboardWrite";
	 }
}