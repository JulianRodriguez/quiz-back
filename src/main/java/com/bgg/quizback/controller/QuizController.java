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

import com.bgg.quizback.component.mapper.quiz.QuizCourseMapper;
import com.bgg.quizback.component.mapper.quiz.QuizMap;
import com.bgg.quizback.component.mapper.quiz.QuizQuestionMap;
import com.bgg.quizback.dao.QuizDAO;
import com.bgg.quizback.dto.QuizCourseDTO;
import com.bgg.quizback.dto.QuizDTO;
import com.bgg.quizback.exception.QuizNotFoundException;
import com.bgg.quizback.model.Quiz;
import com.bgg.quizback.service.QuizService;

@RestController
@RequestMapping()
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	QuizDAO quizdao;
	
	@Autowired
	QuizMap quizMapper;
	
	@Autowired
	QuizCourseMapper quizcoursemapper;
	
	@Autowired
	QuizQuestionMap quizquestionmap;
	
	@RequestMapping(value = "/quiz", method = RequestMethod.GET)
	public Set<QuizDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		
		final Set<Quiz> Quiz =  quizService.findAll(PageRequest.of(page, size));
		return quizMapper.modelToDto(Quiz);
	}

	@RequestMapping(value = "/quiz", method = RequestMethod.POST)
	public QuizDTO create(@RequestBody QuizDTO dto) {
		final Quiz Quiz = quizMapper.dtoToModel(dto);
		final Quiz createquestionary = quizService.create(Quiz);
		return quizMapper.modelToDto(createquestionary);
	}

	
	@RequestMapping(value = "/quiz/{idQuiz}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("idQuiz") Integer idQuiz) throws QuizNotFoundException {
		Optional<Quiz> q = quizService.findById(idQuiz);
		if(!q.isPresent())
			throw new QuizNotFoundException();

		quizService.delete(idQuiz);
	}
	
	
	@RequestMapping(value = "/quiz/{idQuiz}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable Integer idQuiz, @RequestBody QuizDTO dto) throws QuizNotFoundException{
		Optional<Quiz> quiz = quizService.findById(idQuiz);
		if(!quiz.isPresent())
			throw new QuizNotFoundException();
		
		Quiz q = quizService.findByIdQuiz(idQuiz);
		q.setName(dto.getName());
		quizService.update(q);
	}
	
	@RequestMapping(value = "/course/{idCourse}/quiz", method = RequestMethod.GET)
	public Set<QuizCourseDTO> findByidCourseQuiz(@PathVariable Integer idCourse) {
		 final Set<Quiz> Quiz = quizService.findByIdCourse(idCourse);
		return quizcoursemapper.modelToDto(Quiz);
	}
	
	@RequestMapping(value = "/course/{idCourse}/quiz/{idQuiz}",method = RequestMethod.POST)
	public void addcourse(@PathVariable Integer idCourse, @PathVariable Integer idQuiz){
		quizService.addquizcourse(idCourse, idQuiz);
	}
	
	@RequestMapping(value = "/quiz/{idQuiz}/question/{idQuestion}",method = RequestMethod.POST)
	public void addquizquestion(@PathVariable Integer idQuiz, @PathVariable Integer idQuestion){
		quizService.addquizquestion(idQuiz, idQuestion);
	}
	
	
	
}
