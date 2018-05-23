package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Answer;

@Repository
public interface AnswerDAO extends PagingAndSortingRepository<Answer, Integer>{

}
