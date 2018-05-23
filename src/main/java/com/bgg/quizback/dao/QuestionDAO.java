package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Question;

@Repository
public interface QuestionDAO extends PagingAndSortingRepository<Question, Integer> {

}
