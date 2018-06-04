package com.bgg.quizback.component.mapper.course;

import org.springframework.stereotype.Component;

import com.bgg.quizback.component.mapper.AbstractMapper;
import com.bgg.quizback.dto.CourseUserDTO;
import com.bgg.quizback.model.Course;

@Component
public class CourseUserMapImpl extends AbstractMapper<Course, CourseUserDTO> implements CourseUserMap{

	@Override
	public Class<? extends CourseUserDTO> dtoClazz() {
		return CourseUserDTO.class;
	}

	@Override
	public Class<? extends Course> modelClazz() {
		return Course.class;
	}

}
