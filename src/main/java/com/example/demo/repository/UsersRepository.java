package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Users;

public interface UsersRepository extends JpaRepository<Users,Long>{
	public Users findByUserIdAndUserPw(String userId,String userPw);
	
} 