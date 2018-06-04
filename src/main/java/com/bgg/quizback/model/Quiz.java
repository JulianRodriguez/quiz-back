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
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Quiz {

	public static final String FIELD_COURSE = "course";
	public static final String FIELD_TAG = "tag";
	public static final String FIELD_QUESTION = "question";

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idQuiz;
	
	@Column(nullable = false)
	private String name;
	
	@JoinColumn(name = FIELD_COURSE)
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Course> course;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_QUIZ)
	private Set<Result> result;
	
	@JoinColumn(name = FIELD_TAG)
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Tag> tag;
	
	@JoinColumn(name = FIELD_QUESTION)
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Question> question;

}	
	
