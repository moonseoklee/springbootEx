package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.freeboard.FreeboardInfoService;
import com.example.demo.service.freeboard.FreeboardListService;
import com.example.demo.service.freeboard.FreeboardWriteService;

@Controller
public class FreeboardController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private FreeboardListService freeboardListService;
	
	@Autowired
	private FreeboardWriteService freeboardWriteService;
	
	@Autowired
	private FreeboardInfoService freeboardInfoService;
	
	private int returnIntValue(String stringToInt) {
		return Integer.parseInt(stringToInt);
		
	}
	
	@GetMapping("/freeboard")
	public String freeboard(@RequestParam(value="pageNum",defaultValue="1")String pageNum) {
		
		String page = freeboardListService.freeboardList(returnIntValue(pageNum));
		
		
		return page;
		
	}
	
	@PostMapping("/freeboardWriteRequest")
	public String freeboardWriteRequest(@RequestParam Map<String,String> paramMap) {
		
		String title = paramMap.get("title");
		String content = paramMap.get("content");
		String writer = paramMap.get("writer");
		
		freeboardWriteService.write(title,content,writer);
		
		return "redirect:/freeboard";
	}
	
	@GetMapping("/freeBoardInfo")
	public String getPost(@RequestParam(value="freeId") String freeId) {
		String page = freeboardInfoService.getFreeboardPost(freeId);
		
		return page;
	}
}
