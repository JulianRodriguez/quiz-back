package com.bgg.quizback.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Tag {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idTag;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_TAG)
	private Set<Quiz> quiz;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_TAG)
	private Set<Question> question;
}