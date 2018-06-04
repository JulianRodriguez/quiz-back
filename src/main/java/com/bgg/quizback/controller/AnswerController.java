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

import com.bgg.quizback.component.mapper.answer.AnswerMap;
import com.bgg.quizback.component.mapper.answer.AnswerPostMap;
import com.bgg.quizback.dto.AnswerDTO;
import com.bgg.quizback.dto.AnswerPostDTO;
import com.bgg.quizback.model.Answer;
import com.bgg.quizback.service.AnswerService;


@RestController
public class AnswerController {
	
	
	@Autowired
	AnswerService answerservice;
	
	@Autowired
	AnswerMap answermap;
	
	@Autowired
	AnswerPostMap answerpostmap;
	
	@RequestMapping(value = "/answer", method = RequestMethod.GET)
	public Set<AnswerDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		
		final Set<Answer> answers =  answerservice.findAll(PageRequest.of(page, size));
		return answermap.modelToDto(answers);
	}
	
	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public AnswerPostDTO create(@RequestBody AnswerPostDTO dto){
		final Answer answer = answerpostmap.dtoToModel(dto);
		final Answer createanswer = answerservice.create(answer);
		return answerpostmap.modelToDto(createanswer);

	}
	
	
	@RequestMapping(value = "/question/{idQuestion}/answer/{idAnswer}", method = RequestMethod.POST)
	public void addanswer(@PathVariable Integer idQuestion, @PathVariable Integer idAnswer){
		answerservice.addanswerquestion(idQuestion,idAnswer);

	}

}
