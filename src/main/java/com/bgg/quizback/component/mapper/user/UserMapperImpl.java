package com.bgg.quizback.component.mapper.user;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.UserDTO;
import com.bgg.quizback.model.User;


@Component
public class UserMapperImpl extends AbstractMapper<User, UserDTO> implements UserMapper {
	
	
	@Autowired
	public DozerBeanMapper dozer;
	
	@Override
	public Class<? extends UserDTO> dtoClazz() {
		return UserDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		return User.class;
	}

	@Override
	public User mapper(UserDTO dto) {
		return dozer.map(dto, modelClazz());
	}

	@Override
	public Set<UserDTO> modelToDto(Set<User> u) {
		return u.stream().map(user -> mapper(user)).collect(Collectors.toSet());
	}
	
	@Override
	public Set<User> dtoToModel(Set<UserDTO> dtos){
		return dtos.stream().map(userdto -> mapper(userdto)).collect(Collectors.toSet());

	}

	@Override
	public UserDTO mapper(User u) {
		return dozer.map(u, dtoClazz());
	}
	
}
