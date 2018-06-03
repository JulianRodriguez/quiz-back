package com.bgg.quizback.dto;


import java.util.Date;

import lombok.Data;

@Data
public class CourseDTO {
	
	private Integer idCourse;
	private String name;
	private Date start;
	private Date finish;

}
