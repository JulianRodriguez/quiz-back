package com.bgg.quizback.component.mapper.quiz;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.QuizCourseDTO;
import com.bgg.quizback.model.Quiz;

@Component
public class QuizCourseMapperImpl extends AbstractMapper<Quiz, QuizCourseDTO> implements QuizCourseMapper{

	@Override
	public Class<? extends QuizCourseDTO> dtoClazz() {
		return QuizCourseDTO.class;
	}

	@Override
	public Class<? extends Quiz> modelClazz() {
		return Quiz.class;
	}

}
