package com.bgg.quizback.component.mapper.user;

import java.util.Set;

import com.bgg.quizback.component.mapper.Mapper;
import com.bgg.quizback.dto.UserDTO;
import com.bgg.quizback.model.User;


public interface UserMapper extends Mapper<User, UserDTO>{
	
	public UserDTO mapper(User u);
	public User mapper(UserDTO dto);
	
	public Set<User> dtoToModel(Set<UserDTO> dtos);
	public Set<UserDTO> modelToDto(Set<User> u);
}
