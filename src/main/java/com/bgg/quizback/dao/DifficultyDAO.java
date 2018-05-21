package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bgg.quizback.model.Difficulty;

public interface DifficultyDAO extends PagingAndSortingRepository<Difficulty, Integer>{

	
}
