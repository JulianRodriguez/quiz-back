package com.bgg.quizback.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question{

	public static final String FIELD_TAG = "tag";
	public static final String FIELD_DIFFICULTY = "difficulty";
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer idQuestion;
	
	@Column(nullable = false)
	private String statement;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_QUESTION)
	private Set<Quiz> quiz;
	
	@JoinColumn(name = FIELD_TAG)
	@ManyToOne(fetch = FetchType.LAZY)
	private Tag tag;
	
	@JoinColumn(name = FIELD_DIFFICULTY)
	@ManyToOne(fetch = FetchType.LAZY)
	private Difficulty difficulty;
	
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Answer> answer;
}
	
	
	
	