package com.bgg.quizback.dao;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Course;
import com.bgg.quizback.model.Quiz;
import com.bgg.quizback.model.User;


@Repository
public interface CourseDAO extends PagingAndSortingRepository<Course, Integer>{
	
	Course findByIdCourse(Integer id);
	
	@Modifying
	@Query(value = "INSERT INTO COURSE_USER (course_id_course, user_id_user) VALUES (?1,?2)", nativeQuery = true)
	@Transactional
	public void addCourseUser(@Param("idCourse") Integer idCourse,@Param("idUser") Integer idUser);
	
	
	@Query(value = "SELECT * FROM COURSE AS c "
			+ "JOIN COURSE_USER on c.id_course = COURSE_USER.course_id_course "
			+ "WHERE COURSE_USER.user_id_user = ?1", nativeQuery= true)
	public Set<Course> findByIdUserCourse(@Param(value = "idUser") Integer idUser); 
	
	@Query(value = "SELECT * FROM USER AS u "
			+ "JOIN COURSE_USER on u.id_user = COURSE_USER.user_id_user "
			+ "WHERE COURSE_USER.course_id_course = ?1", nativeQuery= true)
	public Set<User> findByIdCourseUser(@Param(value = "idCourse") Integer idCourse);
	
	@Query(value = "SELECT * FROM QUIZ AS q "
			+ "JOIN QUIZ_COURSE on q.id_quiz = QUIZ_COURSE.quiz_id_quiz "
			+ "WHERE QUIZ_COURSE.course_id_course = ?1", nativeQuery= true)
	public Set<Quiz> findByIdCourseQuiz(@Param(value = "idCourse") Integer idCourse); 
	
}