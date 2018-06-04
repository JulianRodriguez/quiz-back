package com.bgg.quizback.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bgg.quizback.component.mapper.course.CourseMap;
import com.bgg.quizback.component.mapper.course.CourseUserMap;
import com.bgg.quizback.dao.CourseDAO;
import com.bgg.quizback.dto.CourseDTO;
import com.bgg.quizback.dto.CourseUserDTO;
import com.bgg.quizback.model.Course;
import com.bgg.quizback.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CourseController {
	
	@Autowired
	CourseService courseservice;
	
	@Autowired
	CourseDAO coursedao;
	
	@Autowired
	CourseMap coursemapper;
	
	@Autowired
	CourseUserMap courseusermap;
	
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public Set<CourseDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		
		final Set<Course> course =  courseservice.findAll(PageRequest.of(page, size));
		return coursemapper.modelToDto(course);
	}
	
	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public CourseDTO create(@RequestBody CourseDTO dto){
		final Course course = coursemapper.dtoToModel(dto);
		final Course createcourse = courseservice.create(course);
		log.info("nombre"+createcourse.getName());
		return coursemapper.modelToDto(createcourse);
	}
	
	@RequestMapping(value = "/user/{idUser}/course", method = RequestMethod.GET)
	public Set<CourseUserDTO> findByidUserCourse(@PathVariable Integer idUser) {
		 final Set<Course> c = courseservice.findByIdUserCourse(idUser);
		return courseusermap.modelToDto(c);
	}
	

	@RequestMapping(value = "/course/{idCourse}/user/{idUser}", method = RequestMethod.POST)
	public void adduser(@PathVariable Integer idCourse, @PathVariable Integer idUser) {
		courseservice.addusercourse(idCourse, idUser);
	}

	
	
}