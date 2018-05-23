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

import com.bgg.quizback.controller.mapper.user.UserMapper;
import com.bgg.quizback.dto.UserDTO;
import com.bgg.quizback.dto.UserPostDTO;
import com.bgg.quizback.model.User;
import com.bgg.quizback.service.UserService;



@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserMapper userMapper;

	@RequestMapping(method = RequestMethod.GET)
	public Set<UserDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<User> users = userService.findAll(PageRequest.of(page, size));
		return userMapper.modelToDto(users);
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserPostDTO dto) {
		final User user = userMapper.dtoToModel(dto);
		final User createUser = userService.create(user);
		return userMapper.modelToDto(createUser);
	}
/*
	@RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
	public void updatePerson(@PathVariable Integer idUser) {
		final User user = userService.findById(idUser);
		userService.delete(user);
	}
	*/
	
	@RequestMapping(value = "/{idUser}", method = RequestMethod.PUT)
	public void updatePerson(@PathVariable Integer idUser, @RequestBody User user) {
		userService.update(user);
	}



}