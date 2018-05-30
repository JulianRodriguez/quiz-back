package com.bgg.quizback.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Course {

	public static final String FIELD_USER = "user";

	@Id
	@GeneratedValue
	private Integer idCourse;

	@Column(nullable = false)
	private String name;
	
	@Temporal(TemporalType.TIME)
	private Date start;
	
	@Temporal(TemporalType.TIME)
	private Date finish;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Quiz.FIELD_COURSE)
	private List<Quiz> quiz;

	@JoinColumn(name = FIELD_USER)
	@ManyToMany(fetch = FetchType.LAZY)
	private List<User> user;
}
