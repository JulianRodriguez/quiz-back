package com.bgg.quizback.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bgg.quizback.component.mapper.quiz.QuizMapper;
import com.bgg.quizback.dao.QuizDAO;
import com.bgg.quizback.dto.QuizDTO;
import com.bgg.quizback.model.Quiz;
import com.bgg.quizback.service.QuizService;

@RestController
@RequestMapping(value = "/quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	QuizDAO quizdao;
	
	@Autowired
	QuizMapper quizMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	public Set<QuizDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		
		final Set<Quiz> questionaries =  quizService.findAll(PageRequest.of(page, size));
		return quizMapper.modelToDto(questionaries);
	}

	@RequestMapping(method = RequestMethod.POST)
	public QuizDTO create(@RequestBody QuizDTO dto) {
		final Quiz questionary = quizMapper.mapper(dto);
		final Quiz createquestionary = quizService.create(questionary);
		return quizMapper.mapper(createquestionary);
	}

	
	@RequestMapping(value = "/{idQuiz}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("idQuiz") Integer idQuiz) {
		quizService.delete(idQuiz);
	}
	
	
	@RequestMapping(value = "/{idQuiz}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable Integer idQuiz, @RequestBody QuizDTO dto) {
		Quiz q = quizService.findByIdQuiz(idQuiz);
		q.setName(dto.getName());
		quizService.update(q);
	}
	
}
