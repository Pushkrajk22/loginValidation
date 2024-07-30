package com.loginservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginservice.model.UserModel;
import com.loginservice.repository.UserRepoJPA;

@Service
public class LoginService {
	
	@Autowired
	UserRepoJPA repo;

	public String validateLogin(String email, String password) {
		List<UserModel> user = repo.findByEmailAndAndPassword(email, password);
		if(user.isEmpty()) {
			return "Invalid Credentials ";
		}
		else if(user.get(0).getEmail().equals(email) && user.get(0).getPassword().equals(password)) {
			return "Login Successful !";
		}
		return null;
	}

	public String validateSignUp(UserModel user) {
		if(repo.findById(user.getEmail()).isPresent()) {
			return "Email Already Exists...";
		}
		else {
			repo.save(user);
			return "User Registered Successfully!";
		}
	}

}
