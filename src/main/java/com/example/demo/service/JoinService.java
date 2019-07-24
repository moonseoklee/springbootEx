package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;


@Service
public class JoinService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private hassingClass userPasswordHashClass;
	
	
	
	
	public String joinUser(String userId, String userPw, String userName) {
		 
		if(userId.equals("") || userPw.equals("")||userName.equals("")) {
			return "join";
		}
		
		Users users = new Users();
		users.setUserId(userId);
        String hashedPassword=userPasswordHashClass.getSHA256(userPw);
		users.setUserPw(hashedPassword);
		users.setUserName(userName);
		
		
		 
		usersRepository.save(users);
		
		return "index";
	}

	
}