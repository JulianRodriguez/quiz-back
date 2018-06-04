package com.bgg.quizback.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Answer;

@Repository
public interface AnswerDAO extends PagingAndSortingRepository<Answer, Integer>{

	
	@Modifying
	@Query(value = "INSERT INTO QUESTION_ANSWER (question_id_question, answer_id_answer) VALUES (?1,?2)", nativeQuery = true)
	@Transactional
	public void addanswerquestion(@Param("idQuestion") Integer idCourse,@Param("idAnswer") Integer idUser);
	
	
	
}
