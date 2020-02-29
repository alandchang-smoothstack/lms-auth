package com.smoothstack.lms.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.smoothstack.lms.auth.model.User;
import com.smoothstack.lms.auth.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User loadUserByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}

	public User loadByUsernameNoPassword(String username) {
		User user = userRepository.findOneByUsername(username);
		user.setPassword(null);
		return user;
	}

}