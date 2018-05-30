package com.bgg.quizback.dto;

import java.util.List;

import com.bgg.quizback.model.Course;

import lombok.Data;

@Data
public class UserDTO {

	private Integer idUser;
	private String name;
	private String email;

}
