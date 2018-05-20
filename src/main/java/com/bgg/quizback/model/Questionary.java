package com.bgg.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Cuestionario {


	@Id
	@GeneratedValue
	private Integer idCuestionario;
	
	@Column(nullable = false)
	private String tipo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Curso.FIELD_CUESTIONARIO)
	private List<Curso> curso;
}