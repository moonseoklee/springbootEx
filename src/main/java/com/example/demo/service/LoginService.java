package com.example.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class LoginService {
	
	@Autowired
	private hassingClass userPasswordHashClass;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	HttpSession session;
	public String login(String userId,String userPw) {
		if(userId.equals("")||userPw.equals("")) {
			return "login";
		}
		
		String hashedPassword = userPasswordHashClass.getSHA256(userPw);
				
		Users users = usersRepository.findByUserIdAndUserPw(userId,hashedPassword);
		if(users==null) {
			
			return "login"; 
		}
		session.setAttribute("loginUser",users);
		System.out.println("login Success");
		return "index";
	}
}
