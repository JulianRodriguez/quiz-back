package com.bgg.quizback.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bgg.quizback.dao.CourseDAO;
import com.bgg.quizback.model.Course;
import com.bgg.quizback.model.Quiz;
import com.bgg.quizback.model.User;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseDAO coursedao;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	QuizService quizservice;
	
	@Override
	public Course create(Course t) {
		return coursedao.save(t);
	}

	@Override
	public void update(Course t) {
		coursedao.save(t);
	}

	public Optional<Course> findById(Integer id) {
		return coursedao.findById(id);
	}

	@Override
	public Set<Course> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return coursedao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Course t) {
		coursedao.delete(t);
		
	}

	@Override
	public Course findByIdCourse(Integer id) {
		return coursedao.findByIdCourse(id);
	}

	@Override
	public User findByIdUser(Integer id){
		User user = userservice.findByIdUser(id);
		return user;
		}

	@Override
	public Quiz findByIdQuiz(Integer idQuiz) {
		Quiz quiz = quizservice.findByIdQuiz(idQuiz);
		return quiz;
	}

	@Override
	public void addusercourse(Integer idCourse, Integer idUser) {
		coursedao.addCourseUser(idCourse, idUser);
		
	}

	@Override
	public Set<Course> findByIdUserCourse(Integer id) {
		return coursedao.findByIdUserCourse(id);
	}

	@Override
	public Set<User> findByIdCourseUser(Integer id) {
		return coursedao.findByIdCourseUser(id);
	}
	
	@Override
	public Set<Quiz> findByIdCourseQuiz(Integer id) {
		return coursedao.findByIdCourseQuiz(id);
	}

}
