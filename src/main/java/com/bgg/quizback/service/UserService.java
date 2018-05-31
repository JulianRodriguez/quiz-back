package com.bgg.quizback.service;

import java.util.Optional;
import java.util.Set;

import com.bgg.quizback.model.Quiz;
import com.bgg.quizback.model.User;

public interface UserService extends AbstractCRUBService<User, Integer>{

	void delete(Integer idUser);
	User findByIdUser(Integer id);
	//Set<Quiz> findByIdCourse(Integer id);


}
