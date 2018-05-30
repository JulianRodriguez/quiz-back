package com.bgg.quizback.service;

import java.util.Optional;

import com.bgg.quizback.model.Quiz;

public interface QuizService extends AbstractCRUBService<Quiz, Integer>{

	void delete(Integer idQuiz);
	Quiz findByIdQuiz(Integer idQuiz);
}
