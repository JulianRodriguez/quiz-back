package com.bgg.quizback.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.bgg.quizback.model.Quiz;
import com.bgg.quizback.model.User;

public interface UserService extends AbstractCRUBService<User, Integer>{

	void delete(Integer idUser);
	User findByIdUser(Integer id);
	List<User> findByIdUsers(List<Integer> id);


}
