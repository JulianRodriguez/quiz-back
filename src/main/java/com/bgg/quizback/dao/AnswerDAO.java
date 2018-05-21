package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bgg.quizback.model.Answer;

public interface AnswerDAO extends PagingAndSortingRepository<Answer, Integer>{

}
