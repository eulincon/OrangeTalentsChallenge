package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

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
public class UserInputDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Email
	private String email;
}
