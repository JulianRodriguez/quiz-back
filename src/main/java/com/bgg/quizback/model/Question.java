package com.bgg.quizback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question{

	public static final String FIELD_TAG = "tag";
	public static final String FIELD_DIFFICULTY = "difficulty";
	
	@Id
	@GeneratedValue
	private Integer idPreguntas;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Questionary.FIELD_QUESTION)
	private List<Questionary> questionary;
	
	@JoinColumn(name = FIELD_TAG)
	@ManyToOne(fetch = FetchType.LAZY)
	private Tag tag;
	
	@JoinColumn(name = FIELD_DIFFICULTY)
	@ManyToOne(fetch = FetchType.LAZY)
	private Difficulty difficulty;
}
	
	
	
	