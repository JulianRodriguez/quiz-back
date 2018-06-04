package com.bgg.quizback.component.mapper.question;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.QuestionDTO;
import com.bgg.quizback.model.Question;

@Component
public class QuestionMapImpl extends AbstractMapper<Question, QuestionDTO> implements QuestionMap{

	@Override
	public Class<? extends QuestionDTO> dtoClazz() {
		return QuestionDTO.class;
	}

	@Override
	public Class<? extends Question> modelClazz() {
		return Question.class;
	}

}
