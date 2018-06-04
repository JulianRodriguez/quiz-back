package com.bgg.quizback.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bgg.quizback.component.mapper.question.QuestionAnswerMap;
import com.bgg.quizback.component.mapper.question.QuestionMap;
import com.bgg.quizback.dao.QuestionDAO;
import com.bgg.quizback.dto.CreateDTO;
import com.bgg.quizback.dto.DeleteDTO;
import com.bgg.quizback.dto.QuestionAnswerDTO;
import com.bgg.quizback.dto.QuestionDTO;
import com.bgg.quizback.dto.UpdateDTO;
import com.bgg.quizback.exception.QuestionNotFoundException;
import com.bgg.quizback.model.Question;
import com.bgg.quizback.service.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
	@Autowired
	QuestionDAO questiondao;
	
	@Autowired
	QuestionMap questionmapper;
	
	@Autowired
	QuestionAnswerMap questionanswermap;
	
	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public Set<QuestionDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		
		final Set<Question> question =  questionservice.findAll(PageRequest.of(page, size));
		return questionmapper.modelToDto(question);
	}
	
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public CreateDTO create(@RequestBody QuestionDTO dto){
		CreateDTO createdto = new CreateDTO();
		final Question question = questionmapper.dtoToModel(dto);
		final Question createquestion = questionservice.create(question);
		return createdto;
	}

	@RequestMapping(value = "/question/{idQuestion}", method = RequestMethod.DELETE)
	public DeleteDTO deleteQuestion(@PathVariable("idQuestion") Integer idQuestion) throws QuestionNotFoundException{
		DeleteDTO deletedto = new DeleteDTO();
		Optional<Question> q = questionservice.findById(idQuestion);
		if(!q.isPresent())
			throw new QuestionNotFoundException();

		questionservice.delete(idQuestion);
		return deletedto;
	}
	
	@RequestMapping(value = "/quiz/{idQuiz}/question", method = RequestMethod.GET)
	public Set<QuestionAnswerDTO> findByidUserCourse(@PathVariable Integer idQuiz) {
		 final Set<Question> q = questionservice.findByIdQuestionQuiz(idQuiz);
		return questionanswermap.modelToDto(q);
	}
	
	@RequestMapping(value = "/quiz/{idQuiz}/question/{idQuestion}", method = RequestMethod.GET)
	public QuestionAnswerDTO findByidUserCourse(@PathVariable Integer idQuiz, @PathVariable Integer idQuestion) {
		 final Question q = questionservice.findByIdQuestion(idQuiz,idQuestion);
		return questionanswermap.modelToDto(q);
	}
	
	
	
	@RequestMapping(value = "/question/{idQuestion}", method = RequestMethod.PUT)
	public UpdateDTO updateQuestion(@PathVariable Integer idQuestion, @RequestBody QuestionDTO dto) throws QuestionNotFoundException{
		UpdateDTO updatedto = new UpdateDTO();
		Optional<Question> q = questionservice.findById(idQuestion);
		if(!q.isPresent())
			throw new QuestionNotFoundException();
		
		Question question = questionservice.findByIdQuestion(idQuestion);
		question.setStatement(dto.getStatement());

		questionservice.update(question);
		return updatedto;
	}
	
}
