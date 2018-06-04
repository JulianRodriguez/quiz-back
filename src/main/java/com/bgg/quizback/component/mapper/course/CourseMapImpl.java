package com.bgg.quizback.component.mapper.course;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.CourseDTO;
import com.bgg.quizback.model.Course;

@Component
public class CourseMapImpl extends AbstractMapper<Course, CourseDTO> implements CourseMap{

	@Override
	public Class<? extends CourseDTO> dtoClazz() {
		return CourseDTO.class;
	}

	@Override
	public Class<? extends Course> modelClazz() {
		return Course.class;
	}

}
