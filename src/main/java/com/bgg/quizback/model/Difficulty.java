package com.bgg.quizback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Difficulty {
	
	@Id
	@GeneratedValue
	private Integer idDificultad;
	
	private String type;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_DIFFICULTY)
	private List<Question> questions;
	

}