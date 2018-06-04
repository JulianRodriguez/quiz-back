package com.bgg.quizback.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bgg.quizback.model.User;

@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Integer>{

	Optional<User> findById(Integer idUser);
	Optional<User> findByEmail(String s);
	User findByIdUser(Integer idUser);
	void save(Optional<User> t);
	User findByIdUser(Set<Integer> id);
	
	@Query(value = "SELECT * FROM USER AS u "
			+ "JOIN COURSE_USER on u.id_user = COURSE_USER.user_id_user "
			+ "WHERE COURSE_USER.course_id_course = ?1", nativeQuery= true)
	public Set<User> findByidUserCourse(@Param(value = "idCourse") Integer idCourse);
}
