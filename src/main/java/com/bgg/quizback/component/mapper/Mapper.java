package com.bgg.quizback.component.mapper;

import java.util.Set;


public interface Mapper<M, D>{

	/*
	M dtoToModel(D dto);

	D modelToDto(M model);

	Class<? extends D> dtoClazz();

	Class<? extends M> modelClazz();
	*/
	
	//public UserDTO mapper(User u);
	//public User mapper(UserDTO u);
	Class<? extends D> dtoClazz();
	Class<? extends M> modelClazz();

}