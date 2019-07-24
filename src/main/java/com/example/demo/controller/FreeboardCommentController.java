package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.hateoas.MediaTypes;
import com.example.demo.model.Freeboard;
import com.example.demo.model.FreeboardComment;
import com.example.demo.repository.FreeboardCommentRepository;
import com.example.demo.service.freeboardComment.FreeboardCommentListService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FreeboardCommentController {

	@Autowired
	private FreeboardCommentListService freeboardCommentListService;
	@Autowired
	private FreeboardCommentRepository freeboardCommentRepository;
	@Autowired
	private HttpSession session;
	@Autowired
	private ObjectMapper objectMapper;
	
	@GetMapping(value="/freeboardCommentList",produces=MediaTypes.HAL_JSON_UTF8_VALUE)
	public @ResponseBody String freeboardCommentList() {
		Freeboard freeboard = (Freeboard)session.getAttribute("freeboard");
		List<FreeboardComment> commentList = freeboardCommentListService.getList(freeboard.getFreeId());
		String value = null;
		try {
			value = objectMapper.writeValueAsString(commentList);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	@PostMapping("/freeboardCommentWrite")
	public @ResponseBody String freeboardCommentWrite(@RequestBody FreeboardComment freeboardComment) {
		
		freeboardCommentRepository.save(freeboardComment);
		return "freeboardComment inserted";
	}
	
}
