package com.example.demo.service.freeboard;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Freeboard;
import com.example.demo.pageMaker.PageMaker;
import com.example.demo.repository.FreeboardRepository;

@Service
public class FreeboardListService {
	
	@Autowired
	private FreeboardRepository freeboardRepository;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private PageMakerService pageMakerService;
	
	public String freeboardList(int pageNum){
		
		PageMaker pageMaker = pageMakerService.generatePageMaker(pageNum,10,freeboardRepository);
		
		PageRequest pageRequest = PageRequest.of(pageNum-1,10,Sort.Direction.DESC,"freeId");
		Page<Freeboard> freeboardPage = freeboardRepository.findAll(pageRequest);
		
		if(freeboardPage.getSize()==0) {
			session.setAttribute("pageMaker",pageMaker);
			session.setAttribute("boardList",new ArrayList<Freeboard>());
			 
			return "freeboard";
		}
		
		List<Freeboard> freeboardList = freeboardPage.getContent();
		session.setAttribute("boardList",freeboardList);	
		session.setAttribute("pageMaker",pageMaker);
		return "freeboard";
	}
}
