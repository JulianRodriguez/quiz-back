package com.bgg.quizback.component.mapper.question;

import java.util.Set;

import com.bgg.quizback.component.mapper.Mapper;
import com.bgg.quizback.dto.QuestionDTO;
import com.bgg.quizback.model.Question;

public interface QuestionMapper extends Mapper<Question, QuestionDTO>{
	
	public QuestionDTO mapper(Question u);
	public Question mapper(QuestionDTO dto);
	
	public Set<Question> dtoToModel(Set<QuestionDTO> dtos);
	public Set<QuestionDTO> modelToDto(Set<Question> q);

}
