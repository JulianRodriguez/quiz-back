package com.bgg.quizback.service;

import com.bgg.quizback.model.Answer;

public interface AnswerService extends AbstractCRUBService<Answer, Integer>{

	void addanswerquestion(Integer idQuestion, Integer idAnswer);
}
