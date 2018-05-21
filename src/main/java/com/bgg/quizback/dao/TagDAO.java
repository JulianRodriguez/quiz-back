package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bgg.quizback.model.Tag;

public interface TagDAO extends PagingAndSortingRepository<Tag, Integer>{

}
