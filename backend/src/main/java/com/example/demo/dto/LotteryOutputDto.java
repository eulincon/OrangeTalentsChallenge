package com.example.demo.dto;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class LotteryOutputDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String numbers;
	private Instant moment;
	private UserInputDto user;
}
