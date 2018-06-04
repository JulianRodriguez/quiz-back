package com.bgg.quizback.component.mapper.quiz;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.QuizDTO;
import com.bgg.quizback.model.Quiz;

@Component
public class QuizMapImpl extends AbstractMapper<Quiz, QuizDTO> implements QuizMap{

	@Override
	public Class<? extends QuizDTO> dtoClazz() {
		return QuizDTO.class;
	}

	@Override
	public Class<? extends Quiz> modelClazz() {
		return Quiz.class;
	}

}
