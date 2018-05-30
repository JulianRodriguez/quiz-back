package com.bgg.quizback.dto;

import java.util.List;

import com.bgg.quizback.model.Course;
import com.bgg.quizback.model.Question;
import com.bgg.quizback.model.Result;
import com.bgg.quizback.model.Tag;

import lombok.Data;

@Data
public class QuizDTO {

	private Integer idQuiz;
	private String tipo;	
	private String name;
	
	/*
	private Integer idCourse;
	private List<Integer> idResult;
	private List<Integer> idTag;
	private List<Integer> idPreguntas;
	*/

}
