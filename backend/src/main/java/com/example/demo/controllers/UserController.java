package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.LotteryOutputDto;
import com.example.demo.dto.UserInputDto;
import com.example.demo.entities.User;
import com.example.demo.services.LotteryService;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LotteryService lotteryService;
	
	@PostMapping(value = "/generate")
	public ResponseEntity<LotteryOutputDto> generateNumbers(@RequestBody @Valid UserInputDto userInputDto){
		
		User user = userService.findByEmail(userInputDto.getEmail());
		
		if(user == null) {
			user = userService.create(userInputDto);
		}
		
		LotteryOutputDto lotteryOutDto = lotteryService.bet(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(lotteryOutDto);
	}
	
	@GetMapping("/numbers")
	public ResponseEntity<List<LotteryOutputDto>> seeNumbers(@RequestParam String email){
		User user = userService.findByEmail(email);
		
		List<LotteryOutputDto> lotteriesOutputDto = lotteryService.findAllByUser(user);
		
		return ResponseEntity.ok(lotteriesOutputDto);
	}
}
