package com.bgg.quizback.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bgg.quizback.dao.QuizDAO;
import com.bgg.quizback.model.Quiz;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	QuizDAO quizdao;
	
	@Autowired
	CourseService courseservice;
	
	
	@Override
	public Quiz create(Quiz t) {
		return quizdao.save(t);
	}

	@Override
	public void update(Quiz t) {
		quizdao.save(t);
		
	}

	@Override
	public Optional<Quiz> findById(Integer id) {
		
		return quizdao.findById(id);
	}

	@Override
	public Set<Quiz> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return quizdao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Quiz t) {
		quizdao.delete(t);
		
	}
	@Override
	public void delete(Integer id) {
		quizdao.deleteById(id);
		
	}

	@Override
	public Quiz findByIdQuiz(Integer idQuiz) {
		return quizdao.findByIdQuiz(idQuiz);
	}

	@Override
	public void addquizcourse(Integer idCourse, Integer idQuiz) {
		quizdao.addquizcourse(idCourse,idQuiz);
		
	}

	@Override
	public Set<Quiz> findByIdCourse(Integer id) {
		return quizdao.findByIdCourse(id);
	}

	@Override
	public void addquizquestion(Integer idQuiz, Integer idQuestion) {
		quizdao.addquizquestion(idQuiz,idQuestion);
		
	}
	


}
