package com.example.demo.Services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.Answer;
import com.example.demo.Repository.AnswerRepository;
import com.example.demo.Repository.QuestionRepository;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository answerRepository;

	@Autowired
	QuestionService questionService;

	/*
	 * @param answer this contain answer info.
	 * 
	 * @param questionid for update answercond in question table
	 */

	public void addAnswer(Answer answer, int questionId) {

		questionService.answeredQuestion(questionId);// to update question answerCond from false to true

		answerRepository.save(answer);
		System.out.println("Answer Saved !");

	}

	/*
	 * @param answerId to remove this answer
	 * 
	 * @param questionid to update answercond in question table to false
	 */
	public void deleteAnswer(int answerId, int questionId) {

		System.out.println("Answer id  = " + answerId + " question id = " + questionId);

		 questionService.answeredQuestion(questionId);// to update question answerCond
		// from true to false

		// answerRepository.deleteById(answerId);
		answerRepository.deleteById(answerId);

		System.out.println("Answer deleted !");

	}

	// just for testing
	public Answer getAnswerById(int id) {

		Answer answer = answerRepository.findById(id).get();

		return answer;

	}

	// uncompleted yet
	public void countAction() {

	}

	
	
}
