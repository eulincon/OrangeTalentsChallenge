package com.example.demo.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BetsByEmailDto implements Serializable{
private static final long serialVersionUID = 1L;
	
	private UserInputDto user;
	private List<Bet> bets;

	
	@Builder
	@Setter
	@AllArgsConstructor
	@Getter
	@NoArgsConstructor
	public static class Bet {
		private Long id;
		private String numbers;
		private Instant moment;
	}
}
