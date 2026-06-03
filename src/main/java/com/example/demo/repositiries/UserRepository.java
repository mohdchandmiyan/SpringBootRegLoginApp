package com.example.demo.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	
}
