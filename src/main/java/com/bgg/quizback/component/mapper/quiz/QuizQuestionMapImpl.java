package com.bgg.quizback.component.mapper.quiz;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.QuestionAnswerDTO;
import com.bgg.quizback.model.Quiz;

@Component
public class QuizQuestionMapImpl extends AbstractMapper<Quiz, QuestionAnswerDTO> implements QuizQuestionMap{

	@Override
	public Class<? extends QuestionAnswerDTO> dtoClazz() {
		return QuestionAnswerDTO.class;
	}

	@Override
	public Class<? extends Quiz> modelClazz() {
		return Quiz.class;
	}

}
