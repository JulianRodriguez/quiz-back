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
	private String name;
}
