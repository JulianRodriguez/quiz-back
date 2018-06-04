package com.bgg.quizback.service;

import java.util.Set;

import com.bgg.quizback.model.Question;

public interface QuestionService extends AbstractCRUBService<Question, Integer>{
	
	Question findByIdQuestion(Integer id);
	void delete(Integer id);
	
	Set<Question> findByIdQuestionQuiz(Integer id);
	
	Question findByIdQuestion(Integer id, Integer id2);


}
