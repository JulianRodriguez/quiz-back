package com.bgg.quizback.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bgg.quizback.dao.UserDAO;
import com.bgg.quizback.model.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userdao;
	
	@Override
	public User create(User t) {
		return userdao.save(t);
	}

	@Override
	 public User findByIdUser(Integer id){
		 return userdao.findByIdUser(id);
	 }

	@Override
	public Optional<User> findById(Integer id) {
		return userdao.findById(id);
	}

	@Override
	public Set<User> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return userdao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(User t) {
		userdao.delete(t);
		
	}
	
	@Override
	public void delete(Integer idUser) {
		userdao.deleteById(idUser);
	}
	
	

	@Override
	public void update(User t) {
		userdao.save(t);
	}

	@Override
	public Set<User> findByIdUsers(Set<Integer> id) {
		Set<User> users = new HashSet<>();
		for(int i=0;i<id.size();i++) {
			User user = userdao.findByIdUser(id);
			users.add(user);
		}
		return users;
	}

	@Override
	public Set<User> findByidUserCourse(Integer id) {
		return userdao.findByidUserCourse(id);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userdao.findByEmail(email);
	}


}