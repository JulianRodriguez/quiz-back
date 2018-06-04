package com.bgg.quizback.component.mapper.user;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.UserDTO;
import com.bgg.quizback.model.User;

@Component
public class UserMapImpl extends AbstractMapper<User, UserDTO> implements UserMap {

	@Override
	public Class<? extends UserDTO> dtoClazz() {
		return UserDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		return User.class;
	}

}
