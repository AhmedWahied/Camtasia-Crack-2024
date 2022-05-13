package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.Follower;
import com.example.demo.Repository.FollowerRepository;
import com.example.demo.Services.FollowerService;

@Controller
@RequestMapping("/friends")
public class FollowerController {

	@Autowired
	FollowerService followerService;

	@RequestMapping(value = "/follow",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void Follow(@RequestBody Follower follower) {

		followerService.Follow(follower);

		System.out.println("Friends Connected !");

	}

	@RequestMapping(value = "/unfollow", method = RequestMethod.DELETE)
	public void unFollow(@RequestParam int id) {
		followerService.unFollow(id);
		System.out.println("unFollow Friends !");

	}
	
	@RequestMapping("")
	@ResponseBody
	public List<Follower> getFriends(@RequestParam int  id){
		
		
	return	followerService.getFriends(id);
	}
	
	

}
