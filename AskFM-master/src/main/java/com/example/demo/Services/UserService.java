package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	/*
	 * @param User object from model package
	 */
	public void addUser(User user) {

		userRepository.save(user);

		System.out.println("user Saved !");

	}

	/*
	 * @param id to delete user account
	 */
	public void deleteUser(int id) {

		userRepository.deleteById(id);
		System.out.println("user deleted !");
	}

	/*
	 * @param user to get user new info.
	 * 
	 * @param id to get last info. for this user , then update it
	 */
	public void updateUser(User user, int id) {

		Optional<User> a = userRepository.findById(id);
		User upUser = a.get();
		upUser.setAllowAnonQuestion(user.getAllowAnonQuestion());
		upUser.setAllowOnDiscoverFeed(user.getAllowOnDiscoverFeed());
		upUser.setAllowSharePosts(user.getAllowSharePosts());
		upUser.setBackgroundImagePath(user.getBackgroundImagePath());
		upUser.setBio(user.getBio());
		upUser.setBirthDay(user.getBirthDay());
		upUser.setEmail(user.getEmail());
		upUser.setFullName(user.getFullName());
		upUser.setGender(user.getGender());
		upUser.setHashTags(user.getHashTags());
		upUser.setLocation(user.getLocation());
//		upUser.setPassWord(user.getPassWord());
		upUser.setProfileImagePath(user.getProfileImagePath());
		upUser.setShowStatus(user.getShowStatus());
		upUser.setUserName(user.getUserName());
		upUser.setWeb(user.getWeb());
		userRepository.save(upUser);

		System.out.println("User Updated !");

	}

	/*
	 * @param id to get user account
	 */
	public User getUserById(int id) {

		User usr = userRepository.findById(id).get();

//		System.out.println(usr.toString());
return usr;
	}

	/*
	 * @param username to get other user data
	 */
	public User getUserByUserName(String userName) {

		User usr = userRepository.findByUserName(userName);
		System.out.println("userRepository.findByUserName(userName) : " + userRepository.findByUserName(userName));
		if (usr == null)
			System.out.println("userNotFound");
		
			return usr;

	}

	/*
	 * this method specially for Admin to know users info.
	 */
	public void getAllUsers() {

		List<User> users = userRepository.findAll();

		users.forEach(user -> System.out.println(user.toString()));

	}

}
