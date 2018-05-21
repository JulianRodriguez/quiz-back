package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bgg.quizback.model.Result;

public interface ResultDAO extends PagingAndSortingRepository<Result, Integer>{

}
