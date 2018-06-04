package com.bgg.quizback.dto;

import java.util.Set;

import com.bgg.quizback.model.Answer;

import lombok.Data;

@Data
public class QuestionAnswerDTO {
	
	private String statement;
	private Set<AnswerDTO> answer;
}
