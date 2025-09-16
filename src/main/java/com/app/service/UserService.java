package com.app.service;

import com.app.entity.User;

public interface UserService {
	User saveUser(User user);
	User findByEmail(String email);
	void updatePassword(Long id, String passwordEncoder);

}
