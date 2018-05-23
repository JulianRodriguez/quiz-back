package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Questionary;

@Repository
public interface QuestionaryDAO extends PagingAndSortingRepository<Questionary, Integer>{

}
