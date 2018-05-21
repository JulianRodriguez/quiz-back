package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.User;

@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Integer>{

	//Optional<User> findOneByNameOrderByIdUserDesc(String name);
	
	
}
