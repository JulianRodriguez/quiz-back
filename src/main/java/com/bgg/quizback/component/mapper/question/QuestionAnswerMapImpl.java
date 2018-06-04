package com.bgg.quizback.component.mapper.question;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.QuestionAnswerDTO;
import com.bgg.quizback.model.Question;

@Component
public class QuestionAnswerMapImpl extends AbstractMapper<Question, QuestionAnswerDTO> implements QuestionAnswerMap{

	@Override
	public Class<? extends QuestionAnswerDTO> dtoClazz() {
		return QuestionAnswerDTO.class;
	}

	@Override
	public Class<? extends Question> modelClazz() {
		return Question.class;
	}

}
