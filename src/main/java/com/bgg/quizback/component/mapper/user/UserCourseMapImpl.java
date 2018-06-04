package com.bgg.quizback.component.mapper.user;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.UserCourseDTO;
import com.bgg.quizback.model.User;

@Component
public class UserCourseMapImpl extends AbstractMapper<User, UserCourseDTO> implements UserCourseMap {

	@Override
	public Class<? extends UserCourseDTO> dtoClazz() {
		return UserCourseDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		return User.class;
	}


}
