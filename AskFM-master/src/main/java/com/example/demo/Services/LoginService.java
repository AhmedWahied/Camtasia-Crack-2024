package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;
	
	
	public User checkValid(User user) {
		System.out.println("*********----------------**************");
	return	userRepository.findByUserNameAndPassWord(user.getUserName(), user.getPassWord());
		
		
	}
	
	
	
}
