package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bgg.quizback.model.Questionary;

public interface QuestionaryDAO extends PagingAndSortingRepository<Questionary, Integer>{

}
