package com.cos.movie.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RegisterReqDto {
	
	@NotNull
	@NotBlank
	private String title;
	private double rating;
}
