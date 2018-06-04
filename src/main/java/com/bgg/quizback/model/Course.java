package com.bgg.quizback.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course {

	public static final String FIELD_USER = "user";

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer idCourse;

	@Column(nullable = false)
	private String name;
	
	@Temporal(TemporalType.TIME)
	private Date start;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_COURSE)
	private Set<Quiz> quiz;

	@JoinColumn(name = FIELD_USER)
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<User> user;
}
