package com.bgg.quizback.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bgg.quizback.dao.AnswerDAO;
import com.bgg.quizback.model.Answer;
import com.bgg.quizback.model.Question;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	AnswerDAO answerdao;
	
	@Autowired
	QuestionService Questionservice;

	@Override
	public Answer create(Answer t) {
		return answerdao.save(t);
	}

	@Override
	public void update(Answer t) {
		answerdao.save(t);
		
	}

	@Override
	public Optional<Answer> findById(Integer id) {
		return answerdao.findById(id);
	}

	@Override
	public Set<Answer> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return answerdao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Answer t) {
		answerdao.delete(t);
		
	}

	@Override
	public void addanswerquestion(Integer idQuestion, Integer idAnswer) {
		Question question = Questionservice.findByIdQuestion(idQuestion);
		Set<Answer> answers = question.getAnswer();
		if(answers.size()<4)
			answerdao.addanswerquestion(idQuestion,idAnswer);
		}

}
