package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.Answer;
import com.example.demo.Model.User;
import com.example.demo.Repository.AnswerRepository;
import com.example.demo.Services.AnswerService;

@Controller
@RequestMapping("/answer")
public class AnswerController {

	// insert, delete ,
	/*
	 * url and param for all methods in Answer Controller
	 * 
	 * URL method Body add -> /add post answer delete -> /delete DELETE param
	 * (answerId:int),param (questionId:int)
	 * 
	 */

	@Autowired
	AnswerService answerService;

	@Autowired
	AnswerRepository answerRepository;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addAnswer(@ModelAttribute Answer answer, HttpServletResponse response) {
		System.out.println(answer.getContentAns());
		System.out.println(answer.getQuestion().getId());
		System.out.println(answer.getUser().getUserName());

		answerService.addAnswer(answer, answer.getQuestion().getId());
		System.out.println("Answer Saved !");
		try {

			response.sendRedirect("/question/getquestions?id=" + answer.getUser().getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "question";
	}

//	@ResponseBody
	@RequestMapping(value = "/delete")
	public String deleteAnswer(@RequestParam(value="answerId") int answerId,
			@RequestParam(value="questionId") int questionId,
			HttpSession session,
			Model model) {

		answerService.deleteAnswer(answerId, questionId);

		User userlogin = (User) session.getAttribute("userlogin");

		model.addAttribute("user", userlogin);

		System.out.println(userlogin.getId());
		List<Answer> anslist = answerRepository.findByUserId(userlogin.getId());
		model.addAttribute("answers", anslist);

		return "profile";

	}

	// for testing only , until now
	@RequestMapping(value = "/getanswer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Answer getAnswerById(@PathVariable(value = "id") int id) {

		Answer answer = answerService.getAnswerById(id);

		return answer;

	}

}
