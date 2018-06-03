package com.bgg.quizback.component.mapper.course;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bgg.quizback.dto.CourseDTO;
import com.bgg.quizback.dto.CourseUserDTO;
import com.bgg.quizback.model.Course;
import com.bgg.quizback.model.User;

@Component
public class CourseMapperImpl implements CourseMapper{
	
	@Autowired
	public DozerBeanMapper dozer;

	@Override
	public Class<? extends CourseDTO> dtoClazz() {
		return CourseDTO.class;
	}

	@Override
	public Class<? extends Course> modelClazz() {
		return Course.class;
	}

	@Override
	public CourseDTO mapper(Course u) {
		return dozer.map(u, dtoClazz());
	}

	@Override
	public Course mapper(CourseDTO dto) {
		return dozer.map(dto, modelClazz());
	}

	@Override
	public Set<Course> dtoToModel(Set<CourseDTO> dtos) {
		return dtos.stream().map(coursedto -> mapper(coursedto)).collect(Collectors.toSet());
	}

	@Override
	public Set<CourseDTO> modelToDto(Set<Course> q) {
		return q.stream().map(course -> mapper(course)).collect(Collectors.toSet());
	}

	@Override
	public Course map(CourseUserDTO dto) {
		return dozer.map(dto, modelClazz());
	}

	
	

}
