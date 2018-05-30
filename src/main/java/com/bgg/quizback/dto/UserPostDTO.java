package com.bgg.quizback.dto;

 
import java.util.List;

import lombok.Data;

@Data
public class UserPostDTO extends UserDTO {

	private String password;
	private List<Integer> idCourse;
	private List<Integer> idResult;

}
