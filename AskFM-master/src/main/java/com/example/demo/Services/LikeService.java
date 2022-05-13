package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Like;
import com.example.demo.Repository.LikeRepository;

@Service
public class LikeService {

	
	@Autowired
	LikeRepository likeRepository;
	
	
	
	public void addLike(Like like) {
		
		likeRepository.save(like);
		System.out.println("liked done");
		
	}
	
	
	public void deleteLike(int userId) {
		likeRepository.deleteById(userId);
		System.out.println("liked deleted !!");
		
	}
	
// just for test
	public List<Like> getLikes() {
		
		 return likeRepository.findAll();
		
	}
	
	
}
