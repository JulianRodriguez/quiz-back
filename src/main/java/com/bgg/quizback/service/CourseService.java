package com.bgg.quizback.service;

import java.util.Set;

import com.bgg.quizback.model.Course;
import com.bgg.quizback.model.Quiz;
import com.bgg.quizback.model.User;

public interface CourseService extends AbstractCRUBService<Course, Integer>{

	Course findByIdCourse(Integer id);
	
	User findByIdUser(Integer id);

	Quiz findByIdQuiz(Integer idQuiz);
	
	void addusercourse(Integer idCourse, Integer idUser);
	
	Set<Quiz> findByIdCourseQuiz(Integer id);	
	
	Set<Course> findByIdUserCourse(Integer id);
	
	Set<User> findByIdCourseUser(Integer id);
	

}
