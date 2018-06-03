package com.bgg.quizback.dto;

import java.util.List;
import java.util.Set;

import com.bgg.quizback.model.User;

import lombok.Data;

@Data
public class CourseUserDTO extends CourseDTO{
	
	private List<User> idUser;
	
}
