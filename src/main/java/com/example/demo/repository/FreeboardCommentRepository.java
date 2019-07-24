package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FreeboardComment;

public interface FreeboardCommentRepository extends JpaRepository<FreeboardComment,Long>{
	List<FreeboardComment> findAllByFreeId(Long freeId);
	
	

}
