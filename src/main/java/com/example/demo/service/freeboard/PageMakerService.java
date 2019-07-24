package com.example.demo.service.freeboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Freeboard;
import com.example.demo.pageMaker.PageMaker;

@Service
public class PageMakerService {
	public PageMaker generatePageMaker(int pageNum, int contentNum, JpaRepository<Freeboard,Long> repository) {
		PageMaker pageMaker=new PageMaker();
		
		int totalCount = (int)repository.count();
		pageMaker.setTotalcount(totalCount);
		pageMaker.setPagenum(pageNum-1);
		pageMaker.setContentnum(contentNum);
		pageMaker.setCurrentblock(pageNum);
		pageMaker.setLastblock(totalCount);
		pageMaker.prevnext(pageNum);
		pageMaker.setStartPage(pageMaker.getCurrentblock());
		pageMaker.setEndPage(pageMaker.getLastblock(), pageMaker.getCurrentblock());
		
		return pageMaker;
	}
	
}
