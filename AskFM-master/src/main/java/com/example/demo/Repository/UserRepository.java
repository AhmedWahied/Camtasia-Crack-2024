package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

User findByUserName(String userName);
User findByUserNameAndPassWord(String username,String password);	
	
	
}
