package com.loginservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginservice.model.UserModel;

@Repository
public interface UserRepoJPA extends JpaRepository<UserModel, String> {
	List<UserModel> findByEmailAndAndPassword(String email, String password);

}
