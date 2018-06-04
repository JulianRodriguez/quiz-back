package com.bgg.quizback.component.mapper.answer;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.AnswerPostDTO;
import com.bgg.quizback.model.Answer;

@Component
public class AnswerPostMapImpl extends AbstractMapper<Answer, AnswerPostDTO> implements AnswerPostMap{

	@Override
	public Class<? extends AnswerPostDTO> dtoClazz() {
		return AnswerPostDTO.class;
	}

	@Override
	public Class<? extends Answer> modelClazz() {
		return Answer.class;
	}


}
