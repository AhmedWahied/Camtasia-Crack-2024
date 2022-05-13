package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Integer>{

}
