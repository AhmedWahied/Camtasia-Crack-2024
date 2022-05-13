package com.example.demo.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="notification")
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text; // some thing like Eslam Elkhafagy " Ask you a question " 
	private String type; // qustion , answer or like
	private Date date;
	private byte isRead;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;// user who received this notifications
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte getIsRead() {
		return isRead;
	}
	public void setIsRead(byte isRead) {
		this.isRead = isRead;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
