package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepo;
import com.app.entity.User;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveUser(User user) {
		User save = userRepo.save(user);
		return save;
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public void updatePassword(Long id, String passwordEncoder) {
		User u = userRepo.findById(id).orElseThrow();
		u.setPassword(passwordEncoder);
		userRepo.save(u);
		
	}

}
