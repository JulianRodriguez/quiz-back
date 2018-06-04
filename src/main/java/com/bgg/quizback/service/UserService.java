package com.bgg.quizback.service;

import java.util.Optional;
import java.util.Set;

import com.bgg.quizback.model.User;

public interface UserService extends AbstractCRUBService<User, Integer>{

	void delete(Integer idUser);
	public User findByIdUser(Integer id);
	public Set<User> findByIdUsers(Set<Integer> id);
	
	Set<User> findByidUserCourse(Integer id);
	
	Optional<User> findByEmail(String email);


}
