package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Answer;

public interface AnswerRepository extends CrudRepository<Answer,Integer> {
	@Modifying
	  @Query(value = "delete FROM answer WHERE id =?", nativeQuery = true)
	void deleteById(int id);
	
	
	List<Answer> findByUserId(int id);
	List<Answer> findByUserUserName(String userName);
	
	
}
