package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Course;


@Repository
public interface CourseDAO extends PagingAndSortingRepository<Course, Integer>{
	
	
}