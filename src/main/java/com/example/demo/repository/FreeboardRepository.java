package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Freeboard;

@Repository
public interface FreeboardRepository extends JpaRepository<Freeboard,Long>{
	Freeboard findByFreeId(Long freeId);
}
