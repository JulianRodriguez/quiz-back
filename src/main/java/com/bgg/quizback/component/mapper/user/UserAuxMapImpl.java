package com.bgg.quizback.component.mapper.user;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.CreateDTO;
import com.bgg.quizback.model.User;

@Component
public class UserAuxMapImpl extends AbstractMapper<User, CreateDTO> implements UserAuxMap{

	@Override
	public Class<? extends CreateDTO> dtoClazz() {
		return CreateDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		return User.class;
	}

}
