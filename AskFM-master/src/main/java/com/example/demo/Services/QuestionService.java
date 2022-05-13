package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Question;
import com.example.demo.Model.User;
import com.example.demo.Repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	/*
	 * @param question to save the question info.
	 */
	public void addQuestion(Question question) {

		questionRepository.save(question);

		System.out.println("Questions Saved !");

	}

	/*
	 * @param id to delete special question
	 */
	public void deleteQuestion(int id) {

		questionRepository.deleteById(id);
		System.out.println("Questions Deleted !");
	}

	/*
	 * @param id to get questions for spacific user
	 */
	public List<Question> getUserQuestions(int id) {

		/*
		 * @param false to selected unAnswered questions
		 * */
		List<Question> all = questionRepository.findByRecUserIdAndAnswerCond(id,false);

		return all;

	}

	/*
	 * this method called when user delete question answered it before main purpose
	 * for it to change answer conditions from true to false
	 * 
	 * or change answer conditions from false to true where user answer it
	 * 
	 * @param id to get question data
	 * 
	 */
	public void answeredQuestion( int id) {

		Question upquestion = questionRepository.findById(id).get();

		if (upquestion.isAnswerCond())
			upquestion.setAnswerCond(false);
		else
			upquestion.setAnswerCond(true);

		questionRepository.save(upquestion);

		System.out.println("Question answered  updated to : "+upquestion.isAnswerCond());

	}

	
	
	
}
