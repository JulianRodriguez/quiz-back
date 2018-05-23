package com.bgg.quizback.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.Tag;

@Repository
public interface TagDAO extends PagingAndSortingRepository<Tag, Integer>{

}
