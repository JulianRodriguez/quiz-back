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

import com.bgg.quizback.component.mapper.question.QuestionMapper;
import com.bgg.quizback.dao.QuestionDAO;
import com.bgg.quizback.dto.QuestionDTO;
import com.bgg.quizback.model.Question;
import com.bgg.quizback.service.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
	@Autowired
	QuestionDAO questiondao;
	
	@Autowired
	QuestionMapper questionmapper;
	
	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public Set<QuestionDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		
		final Set<Question> question =  questionservice.findAll(PageRequest.of(page, size));
		return questionmapper.modelToDto(question);
	}
	
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public QuestionDTO create(@RequestBody QuestionDTO dto){
		final Question question = questionmapper.mapper(dto);
		final Question createquestion = questionservice.create(question);
		return questionmapper.mapper(createquestion);
	}
	
	@RequestMapping(value = "/question/{idQuestion}", method = RequestMethod.DELETE)
	public void deleteQuestion(@PathVariable("idQuestion") Integer idQuestion) {
		questionservice.delete(idQuestion);
	}
	
	
	@RequestMapping(value = "/question/{idQuestion}", method = RequestMethod.PUT)
	public void updateQuestion(@PathVariable Integer idQuestion, @RequestBody QuestionDTO dto) {
		Question question = questionservice.findByIdQuestion(idQuestion);
		question.setStatement(dto.getStatement());

		questionservice.update(question);
	}
	
	@RequestMapping(value = "/quiz/{idQuiz}/question/{idQuestion}", method = RequestMethod.POST)
	public void saveQuizQuestion(@PathVariable Integer idQuestion, @PathVariable Integer idQuiz){
		questionservice.saveQuizQuestion(idQuestion,idQuiz);
	}
	

}
