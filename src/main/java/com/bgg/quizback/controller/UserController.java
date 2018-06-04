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

import com.bgg.quizback.component.mapper.user.UserCourseMap;
import com.bgg.quizback.component.mapper.user.UserMap;
import com.bgg.quizback.component.mapper.user.UserPostMap;
import com.bgg.quizback.dao.UserDAO;
import com.bgg.quizback.dto.UserCourseDTO;
import com.bgg.quizback.dto.UserDTO;
import com.bgg.quizback.dto.UserPostDTO;
import com.bgg.quizback.exception.EmailDuplicatedException;
import com.bgg.quizback.exception.UserNotFoundException;
import com.bgg.quizback.model.User;
import com.bgg.quizback.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserDAO userdao;

	@Autowired
	UserMap userMapper;
	
	@Autowired
	UserPostMap userPostMap;
	
	@Autowired
	UserCourseMap usercoursemap;
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public Set<UserDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<User> users = userService.findAll(PageRequest.of(page, size));
		return userMapper.modelToDto(users);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public UserDTO create(@RequestBody UserPostDTO dto) throws EmailDuplicatedException{
		Optional<User> u = userService.findByEmail(dto.getEmail());
		if(u.isPresent())
			throw new EmailDuplicatedException();
		final User user = userMapper.dtoToModel(dto);
		final User createUser = userService.create(user);
		return userMapper.modelToDto(createUser);
	}

	@RequestMapping(value = "/user/{idUser}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("idUser") Integer idUser) throws UserNotFoundException {
		Optional<User> u = userService.findById(idUser);
		if(!u.isPresent())
			throw new UserNotFoundException();
		userService.delete(idUser);
	}
	
	@RequestMapping(value = "/course/{idCourse}/user", method = RequestMethod.GET)
	public Set<UserCourseDTO> findByidUserCourse(@PathVariable Integer idCourse) {
		 final Set<User> u = userService.findByidUserCourse(idCourse);
		return usercoursemap.modelToDto(u);
	}
	
	
	@RequestMapping(value = "/{idUser}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable Integer idUser, @RequestBody UserPostDTO dto) throws UserNotFoundException {
		Optional<User> u = userService.findById(idUser);
		if(!u.isPresent())
			throw new UserNotFoundException();
		User user = userService.findByIdUser(idUser);
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		userService.update(user);

	}




}