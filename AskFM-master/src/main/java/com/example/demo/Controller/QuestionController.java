package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Question;
import com.example.demo.Model.User;
import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Services.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {

	// insert, delete , updateAnswer, findBYUserID , 
		/*
		 * url and param for all methods in Question Controller
		 * 
		 * 						URL						method				Body            
		 * add ->      			/add					post				question
		 * delete ->   			/delete					DELETE				param (id:int)
		 * updateAnswer ->   	/updateAnswer			PUT					param(id:int)
		 * getUserQuestions->  	/getquestions			GET					param (id:int)
		 * 
		 * */
	
	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String addQuestion(@RequestBody Question question) {
		
		questionService.addQuestion(question);
		
		System.out.println("Questions Saved !");
			return "index";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void deleteQuestion(@RequestParam int id) {
		
		questionService.deleteQuestion(id);
		System.out.println("Questions Deleted !");
	}
	
	 
	@RequestMapping(value="/getquestions", method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value="/getquestions/{id}", method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
	public String getUserQuestions(@RequestParam int id , Model model) {
		List<Question> all = questionService.getUserQuestions(id);
//		System.out.println(all.toString());
		
		model.addAttribute("questions",all );
		return "question";
		
	}
	
	
	@RequestMapping(value="/updateAnswer", method=RequestMethod.PUT ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void UpdateAnsweredQuestion(@RequestParam int id) {
		
		questionService.answeredQuestion(id);
		
	}
	
	
}
