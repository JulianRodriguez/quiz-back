package com.bgg.quizback.service;

import java.util.Set;

import com.bgg.quizback.model.Quiz;

public interface QuizService extends AbstractCRUBService<Quiz, Integer>{

	void delete(Integer idQuiz);
	Quiz findByIdQuiz(Integer idQuiz);
	
	Set<Quiz> findByIdCourse(Integer id);	
	void addquizcourse(Integer idCourse, Integer idQuiz);
	void addquizquestion(Integer idQuiz, Integer idQuestion);
	
}
