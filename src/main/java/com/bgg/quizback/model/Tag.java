package com.bgg.quizback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	private Integer idTag;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = Questionary.FIELD_TAG)
	private List<Questionary> questionary;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_TAG)
	private List<Question> question;
}