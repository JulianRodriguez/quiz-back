package com.bgg.quizback.component.mapper.answer;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.AnswerDTO;
import com.bgg.quizback.model.Answer;

@Component
public class AnswerMapImpl extends AbstractMapper<Answer, AnswerDTO> implements AnswerMap{

	@Override
	public Class<? extends AnswerDTO> dtoClazz() {
		return AnswerDTO.class;
	}

	@Override
	public Class<? extends Answer> modelClazz() {
		return Answer.class;
	}

}
