package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Quiz;
import com.bgg.quizback.model.User;

@Repository
public interface QuizDAO extends PagingAndSortingRepository<Quiz, Integer>{
	
	Quiz findByIdQuiz(Integer idQuiz);



}
