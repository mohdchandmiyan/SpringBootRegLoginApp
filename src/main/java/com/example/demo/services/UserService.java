package com.example.demo.services;

import com.example.demo.entities.User;

public interface UserService {

	public boolean registerUser(User user);

	public User loginUser(String email, String password);

}