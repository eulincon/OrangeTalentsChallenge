package com.example.demo.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Lottery;
import com.example.demo.entities.User;
import com.example.demo.repositories.LotteryRepository;

@Service
public class LotteryService {
	
	@Autowired
	private LotteryRepository lotteryRepository;
	
	public Lottery bet(User user) {
		Lottery lottery = Lottery.builder().moment(Instant.now()).user(user).numbers("1").build();
		
		return lotteryRepository.save(lottery);
	}
}
