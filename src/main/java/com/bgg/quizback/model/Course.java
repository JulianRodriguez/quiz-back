package com.bgg.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Course {

	public static final String FIELD_USER = "user";

	@Id
	@GeneratedValue
	private Integer idCurso;

	@Column(nullable = false)
	private String name;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = Questionary.FIELD_COURSE)
	//private List<Questionary> questionary;

	@JoinColumn(name = FIELD_USER)
	@ManyToMany(fetch = FetchType.LAZY)
	private List<User> user;
}
