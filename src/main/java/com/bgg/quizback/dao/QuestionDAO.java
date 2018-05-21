package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bgg.quizback.model.Question;

public interface QuestionDAO extends PagingAndSortingRepository<Question, Integer> {

}
