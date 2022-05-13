package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Follower;

public interface FollowerRepository extends JpaRepository<Follower,Integer >{

	List<Follower> findByUserFollowId(int id);
	
	
}
