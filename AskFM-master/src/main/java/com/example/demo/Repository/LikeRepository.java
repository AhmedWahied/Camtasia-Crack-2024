package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Like;

public interface LikeRepository extends JpaRepository<Like,Integer>{

	@Modifying
	  @Query(value = "delete FROM likes WHERE id =?", nativeQuery = true)
	void deleteById(int id);
	
	
}
