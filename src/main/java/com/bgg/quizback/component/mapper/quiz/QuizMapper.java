package com.bgg.quizback.component.mapper.quiz;

import java.util.Set;

import com.bgg.quizback.component.mapper.Mapper;
import com.bgg.quizback.dto.QuizDTO;
import com.bgg.quizback.model.Quiz;

public interface QuizMapper extends Mapper<Quiz, QuizDTO>{
	
	public QuizDTO mapper(Quiz u);
	public Quiz mapper(QuizDTO dto);
	
	public Set<Quiz> dtoToModel(Set<QuizDTO> dtos);
	public Set<QuizDTO> modelToDto(Set<Quiz> q);

}
