package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Like;
import com.example.demo.Services.LikeService;

@Controller
@RequestMapping("/like")
public class LikeController {

	
	@Autowired
	LikeService likeService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addLike(@RequestBody Like like) {
		
		likeService.addLike(like);
				
		
	}
	
	@RequestMapping(value="/dislike", method=RequestMethod.DELETE)
	public void disLike(@RequestParam int id) {
		
		likeService.deleteLike(id);
	}
	
	@RequestMapping(value="/getAllLikes", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Like> getlikes(){
		
	return	likeService.getLikes();
		
	}
	
	
}
