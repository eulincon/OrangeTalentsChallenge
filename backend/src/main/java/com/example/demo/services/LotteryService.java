package com.example.demo.services;

import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BetsByEmailDto;
import com.example.demo.dto.LotteryOutputDto;
import com.example.demo.dto.UserInputDto;
import com.example.demo.entities.Lottery;
import com.example.demo.entities.User;
import com.example.demo.repositories.LotteryRepository;

@Service
public class LotteryService {

	@Autowired
	private LotteryRepository lotteryRepository;

	ModelMapper modelMapper = new ModelMapper();

	public LotteryOutputDto bet(User user) {
		Random aleatorio = new Random();
		int valor = aleatorio.nextInt(999) + 1;
		
		Lottery lottery = Lottery.builder().moment(Instant.now()).user(user).numbers(Integer.toString(valor)).build();

		lottery = lotteryRepository.save(lottery);

		LotteryOutputDto lotteryOutputDto = modelMapper.map(lottery, LotteryOutputDto.class);

		return lotteryOutputDto;

	}

	public BetsByEmailDto findAllByUser(User user) {
		List<Lottery> lotteries = lotteryRepository.findByUser(user);

		if (lotteries.isEmpty()) {
			return BetsByEmailDto.builder().build();
		}

		UserInputDto userInputDto = UserInputDto.builder().email(user.getEmail()).build();

		List<LotteryOutputDto> lotteriesOutputDto = lotteries.stream()
				.map((lottery) -> modelMapper.map(lottery, LotteryOutputDto.class)).collect(Collectors.toList());

		BetsByEmailDto betsByEmailDto = BetsByEmailDto.builder().bets(lotteriesOutputDto.stream()
				.map(bet -> modelMapper.map(bet, BetsByEmailDto.Bet.class)).collect(Collectors.toList()))
				.user(userInputDto).build();

		return betsByEmailDto;
	}
}
