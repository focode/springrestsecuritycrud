package com.gotprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gotprint.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT u FROM User u where u.email = :email") 
	User findByEmailId(@Param("email") String email);
}
