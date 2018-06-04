package com.bgg.quizback.dao;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Quiz;

@Repository
public interface QuizDAO extends PagingAndSortingRepository<Quiz, Integer>{
	
	Quiz findByIdQuiz(Integer idQuiz);
	
	@Modifying
	@Query(value = "INSERT INTO QUIZ_COURSE (course_id_course,quiz_id_quiz) VALUES (?1,?2)", nativeQuery = true)
	@Transactional
	public void addquizcourse(@Param("idCourse") Integer idCourse,@Param("idQuiz") Integer idQuiz);
	
	@Query(value = "SELECT * FROM QUIZ AS q "
			+ "JOIN QUIZ_COURSE on q.id_quiz = QUIZ_COURSE.quiz_id_quiz "
			+ "WHERE QUIZ_COURSE.course_id_course = ?1", nativeQuery= true)
	public Set<Quiz> findByIdCourse(@Param(value = "idCourse") Integer idCourse); 
	
	@Modifying
	@Query(value = "INSERT INTO QUIZ_QUESTION (	quiz_id_quiz,question_id_question) VALUES (?1,?2)", nativeQuery = true)
	@Transactional
	public void addquizquestion(@Param("idQuiz") Integer idCourse,@Param("idQuestion") Integer idQuiz);
	

	
	

}
