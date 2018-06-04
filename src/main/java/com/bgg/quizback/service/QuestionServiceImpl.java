package com.bgg.quizback.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bgg.quizback.dao.QuestionDAO;
import com.bgg.quizback.dao.QuizDAO;
import com.bgg.quizback.model.Question;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDAO questiondao;
	
	@Autowired
	QuizDAO quizdao;
	
	@Override
	public Question create(Question t) {
		return questiondao.save(t);
	}

	@Override
	public void update(Question t) {
		questiondao.save(t);
	}

	@Override
	public Optional<Question> findById(Integer id) {
		return questiondao.findById(id);
	}

	@Override
	public Set<Question> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return questiondao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Question t) {
		questiondao.delete(t);
		
	}

	@Override
	public Question findByIdQuestion(Integer id) {
		return questiondao.findByIdQuestion(id);
	}

	@Override
	public void delete(Integer id) {
		questiondao.deleteById(id);
		
	}

	@Override
	public Set<Question> findByIdQuestionQuiz(Integer id) {
		return questiondao.findByIdQuestionQuiz(id);
	}

	@Override
	public Question findByIdQuestion(Integer id, Integer id2) {
		return questiondao.findByIdQuestion(id,id2);
	}



}
