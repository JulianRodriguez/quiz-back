package com.bgg.quizback.controller.mapper.user;

import org.springframework.stereotype.Component;

import com.bgg.quizback.controller.mapper.AbstractMapper;
import com.bgg.quizback.dto.UserDTO;
import com.bgg.quizback.model.User;


@Component
public class UserMapperImpl extends AbstractMapper<User, UserDTO> implements UserMapper {

	@Override
	public Class<? extends UserDTO> dtoClazz() {
		return UserDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		return User.class;
	}

}
