package com.example.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserInputDto;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	public User create(UserInputDto userInputDto) {		
		User user = modelMapper.map(userInputDto, User.class);
		
		return userRepository.save(user);
	}
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
