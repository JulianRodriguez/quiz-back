package com.bgg.quizback.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Result {


	public static final String FIELD_RESULT = "curso";

	@Id
	@GeneratedValue
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@JoinColumn(name = FIELD_RESULT)
	@ManyToOne(fetch = FetchType.LAZY)
	private Curso curso;

}
