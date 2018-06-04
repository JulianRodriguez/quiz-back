package com.bgg.quizback.component.mapper.user;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.UserPostDTO;
import com.bgg.quizback.model.User;

@Component
public class UserPostMapImpl extends AbstractMapper<User, UserPostDTO> implements UserPostMap{

	@Override
	public Class<? extends UserPostDTO> dtoClazz() {
		return UserPostDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		return User.class;
	}

}
