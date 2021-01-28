package com.example.demo.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LotteryOutputDto;
import com.example.demo.entities.Lottery;
import com.example.demo.entities.User;
import com.example.demo.repositories.LotteryRepository;

@Service
public class LotteryService {

	@Autowired
	private LotteryRepository lotteryRepository;

	ModelMapper modelMapper = new ModelMapper();
	
	public LotteryOutputDto bet(User user) {
		Lottery lottery = Lottery.builder().moment(Instant.now()).user(user).numbers("1").build();

		lottery = lotteryRepository.save(lottery);

		LotteryOutputDto lotteryOutputDto = modelMapper.map(lottery, LotteryOutputDto.class);

		return lotteryOutputDto;

	}
	
	public List<LotteryOutputDto> findAllByUser(User user) {
		List<Lottery> lotteries = lotteryRepository.findByUser(user);
		
		List<LotteryOutputDto> lotteriesOutputDto = lotteries.stream().map((lottery) -> modelMapper.map(lottery, LotteryOutputDto.class)).collect(Collectors.toList());
		
		return lotteriesOutputDto;
	}
}
