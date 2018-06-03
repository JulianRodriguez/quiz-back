package com.bgg.quizback.component.mapper.course;

import java.util.Set;

import com.bgg.quizback.component.mapper.Mapper;
import com.bgg.quizback.dto.CourseDTO;
import com.bgg.quizback.dto.CourseUserDTO;
import com.bgg.quizback.model.Course;


public interface CourseMapper extends Mapper<Course, CourseDTO>{
	
	public CourseDTO mapper(Course u);
	public Course mapper(CourseDTO dto);

	
	public Set<Course> dtoToModel(Set<CourseDTO> dtos);
	public Set<CourseDTO> modelToDto(Set<Course> q);
	
	
	public Course map(CourseUserDTO dto);

}
