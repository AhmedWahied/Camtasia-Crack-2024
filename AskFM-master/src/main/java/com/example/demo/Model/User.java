package com.example.demo.Model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String userName;
	private String passWord;
	private String fullName;
	@Email
	private String email;
	private String birthDay;
	private String gender;
	private String location;
	private String bio;
	private String web;
	private String hashTags;
	private byte allowAnonQuestion; // Allow anonymous questions ?
	private byte allowSharePosts; // >Allow other users to share posts ?
	private byte allowOnDiscoverFeed; // Allow showing user answers on Discover feed ?
	private byte showStatus;
	private String profileImagePath; // upload image in file and store path
	private String backgroundImagePath;

	
	/*
	 * Questions Part
	 * 
	 * */
	@OneToMany(mappedBy = "recUser", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Question> reciver_questions = new ArrayList<>();
	
	@OneToMany(mappedBy = "senderUser", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Question> sender_questions = new ArrayList<>();
	
	
	
	/*
	 * 
	 * Friends Part
	 * 
	 * */

	@OneToMany(mappedBy = "userFollow", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Follower> followers = new ArrayList<>();
	
	@OneToMany(mappedBy = "friendFollow", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Follower> friendfollowers = new ArrayList<>();
	
	

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Notification> notifications = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Answer> answer;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Like> like;

	
	
	
	

	public List<Question> getReciver_questions() {
		return reciver_questions;
	}

	public void setReciver_questions(List<Question> reciver_questions) {
		this.reciver_questions = reciver_questions;
	}

	public List<Question> getSender_questions() {
		return sender_questions;
	}

	public void setSender_questions(List<Question> sender_questions) {
		this.sender_questions = sender_questions;
	}

	public List<Follower> getFriendfollowers() {
		return friendfollowers;
	}

	public void setFriendfollowers(List<Follower> friendfollowers) {
		this.friendfollowers = friendfollowers;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public List<Like> getLike() {
		return like;
	}

	public void setLike(List<Like> like) {
		this.like = like;
	}

	public List<Follower> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follower> followers) {
		this.followers = followers;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getHashTags() {
		return hashTags;
	}

	public void setHashTags(String hashTags) {
		this.hashTags = hashTags;
	}

	public byte getAllowAnonQuestion() {
		return allowAnonQuestion;
	}

	public void setAllowAnonQuestion(byte allowAnonQuestion) {
		this.allowAnonQuestion = allowAnonQuestion;
	}

	public byte getAllowSharePosts() {
		return allowSharePosts;
	}

	public void setAllowSharePosts(byte allowSharePosts) {
		this.allowSharePosts = allowSharePosts;
	}

	public byte getAllowOnDiscoverFeed() {
		return allowOnDiscoverFeed;
	}

	public void setAllowOnDiscoverFeed(byte allowOnDiscoverFeed) {
		this.allowOnDiscoverFeed = allowOnDiscoverFeed;
	}

	public byte getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(byte showStatus) {
		this.showStatus = showStatus;
	}

	public String getProfileImagePath() {
		return profileImagePath;
	}

	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	public String getBackgroundImagePath() {
		return backgroundImagePath;
	}

	public void setBackgroundImagePath(String backgroundImagePath) {
		this.backgroundImagePath = backgroundImagePath;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", fullName=" + fullName
				+ ", email=" + email + ", birthDay=" + birthDay + ", gender=" + gender + ", location=" + location
				+ ", bio=" + bio + ", web=" + web + ", hashTags=" + hashTags + ", allowAnonQuestion="
				+ allowAnonQuestion + ", allowSharePosts=" + allowSharePosts + ", allowOnDiscoverFeed="
				+ allowOnDiscoverFeed + ", showStatus=" + showStatus + ", profileImagePath=" + profileImagePath
				+ ", backgroundImagePath=" + backgroundImagePath + ", reciver_questions=" + reciver_questions
				+ ", sender_questions=" + sender_questions + ", followers=" + followers + ", friendfollowers="
				+ friendfollowers + ", notifications=" + notifications + ", answer=" + answer + ", like=" + like + "]";
	}

	
	
}
