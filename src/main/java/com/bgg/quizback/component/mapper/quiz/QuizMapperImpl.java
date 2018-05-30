package com.bgg.quizback.component.mapper.quiz;

import java.util.Set;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.QuizDTO;
import com.bgg.quizback.model.Quiz;

@Component
public class QuizMapperImpl extends AbstractMapper<Quiz, QuizDTO> implements QuizMapper{

	@Autowired
	public DozerBeanMapper dozer;
	
	@Override
	public Class<? extends QuizDTO> dtoClazz() {
		return QuizDTO.class;
	}

	@Override
	public Class<? extends Quiz> modelClazz() {
		return Quiz.class;
	}

	@Override
	public QuizDTO mapper(Quiz u) {
		return dozer.map(u, dtoClazz());
	}

	@Override
	public Quiz mapper(QuizDTO dto) {
		return dozer.map(dto, modelClazz());
	}

	@Override
	public Set<Quiz> dtoToModel(Set<QuizDTO> dtos) {
		return dtos.stream().map(userdto -> mapper(userdto)).collect(Collectors.toSet());

	}

	@Override
	public Set<QuizDTO> modelToDto(Set<Quiz> q) {
		return q.stream().map(quiz -> mapper(quiz)).collect(Collectors.toSet());

	}
	

}
