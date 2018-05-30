package com.bgg.quizback.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Quiz;
import com.bgg.quizback.model.User;

@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Integer>{

	Optional<User> findById(Integer idUser);
	User findByIdUser(Integer idUser);
	void save(Optional<User> t);
	Set<Quiz> findByCourse(Integer idCourse) ;
	
}
