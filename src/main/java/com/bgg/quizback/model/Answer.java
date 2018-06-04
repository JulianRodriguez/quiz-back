package com.bgg.quizback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Answer {
	
	public static final String FIELD_QUESTION = "question";

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idAnswer;
	
	@Column(nullable = false)
	private String answer;
	
	@Column(nullable = false)
	private Boolean correct;
	
	@JoinColumn(name = FIELD_QUESTION)
	@ManyToOne(fetch = FetchType.LAZY)
	private Question question;
	
	
}
