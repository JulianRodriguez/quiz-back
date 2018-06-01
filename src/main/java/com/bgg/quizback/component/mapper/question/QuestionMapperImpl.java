package com.bgg.quizback.component.mapper.question;

import java.util.Set;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bgg.quizback.dto.QuestionDTO;
import com.bgg.quizback.model.Question;

@Component
public class QuestionMapperImpl implements QuestionMapper{
	
	@Autowired
	public DozerBeanMapper dozer;

	@Override
	public Class<? extends QuestionDTO> dtoClazz() {
		return QuestionDTO.class;
	}

	@Override
	public Class<? extends Question> modelClazz() {
		return Question.class;
	}

	@Override
	public QuestionDTO mapper(Question u) {
		return dozer.map(u, dtoClazz());
	}

	@Override
	public Question mapper(QuestionDTO dto) {
		return dozer.map(dto, modelClazz());
	}

	@Override
	public Set<Question> dtoToModel(Set<QuestionDTO> dtos) {
		return dtos.stream().map(questiondto -> mapper(questiondto)).collect(Collectors.toSet());
	}

	@Override
	public Set<QuestionDTO> modelToDto(Set<Question> q) {
		return q.stream().map(question -> mapper(question)).collect(Collectors.toSet());

	}

}
