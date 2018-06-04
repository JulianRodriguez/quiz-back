package com.bgg.quizback.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Question;
import com.bgg.quizback.model.User;

@Repository
public interface QuestionDAO extends PagingAndSortingRepository<Question, Integer> {
	
	Question findByIdQuestion(Integer id);
	
	@Query(value = "SELECT * FROM USER AS u "
			+ "JOIN COURSE_USER on u.id_user = COURSE_USER.user_id_user "
			+ "WHERE COURSE_USER.course_id_course = ?1", nativeQuery= true)
	public Set<User> findByIdCourseUser(@Param(value = "idCourse") Integer idCourse);
	
	
	@Query(value = "SELECT * FROM QUESTION AS q "
			+ "JOIN QUIZ_QUESTION on q.id_question = QUIZ_QUESTION.question_id_question "
			+ "WHERE QUIZ_QUESTION.quiz_id_quiz = ?1", nativeQuery= true)
	public Set<Question> findByIdQuestionQuiz(@Param(value = "idQuiz") Integer idQuiz);
	
	
	@Query(value = "SELECT id_question,statement FROM QUESTION AS q "
			+ "JOIN QUIZ_QUESTION on (q.id_question = ?2) = QUIZ_QUESTION.question_id_question "
			+ "WHERE QUIZ_QUESTION.quiz_id_quiz = ?1", nativeQuery= true)
	public Question findByIdQuestion(@Param(value = "idQuiz") Integer idQuiz,@Param(value = "idQuestion") Integer idQuestion);
	
	
}
