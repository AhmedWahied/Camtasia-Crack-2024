package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Question;
import com.example.demo.Model.User;

public interface QuestionRepository  extends JpaRepository<Question, Integer>{

	
List<Question>	findByRecUserIdAndAnswerCond(int id,boolean answerCond);
	
	
}
