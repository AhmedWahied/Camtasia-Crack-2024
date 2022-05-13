package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.Follower;
import com.example.demo.Repository.FollowerRepository;

@Service
public class FollowerService {

	@Autowired
	FollowerRepository followerRepository;

	
	public void Follow(Follower follower) {

		followerRepository.save(follower);

		System.out.println("Friends Connected !");

	}

	public void unFollow( int id) {
		followerRepository.deleteById(id);
		System.out.println("unFollow Friends !");

	}
	
	public List<Follower> getFriends(@RequestParam int  id){
		
		
	return	followerRepository.findByUserFollowId(id);
	}
	
	
	
	
}
