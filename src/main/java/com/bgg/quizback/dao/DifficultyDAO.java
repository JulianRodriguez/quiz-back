package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Difficulty;

@Repository
public interface DifficultyDAO extends PagingAndSortingRepository<Difficulty, Integer>{

	
}
