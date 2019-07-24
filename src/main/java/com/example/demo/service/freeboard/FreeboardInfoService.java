package com.example.demo.service.freeboard;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Freeboard;
import com.example.demo.repository.FreeboardRepository;



@Service
public class FreeboardInfoService {
	@Autowired
	private FreeboardRepository freeboardRepository; 
	
	@Autowired private HttpSession session;
	public String getFreeboardPost(String stringFreeId) {
		Long freeId = Long.parseLong(stringFreeId);
		Freeboard freeboard = freeboardRepository.findByFreeId(freeId);
		if(freeboard ==null) {
			return "freeboard";
		}
		
		session.setAttribute("freeboard",freeboard);
		
		return "freeboardInfo";
	}
}
