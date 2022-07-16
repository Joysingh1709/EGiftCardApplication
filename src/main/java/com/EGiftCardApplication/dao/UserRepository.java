package com.EGiftCardApplication.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.EGiftCardApplication.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
  	
	@Query("From User u where u.email=:email AND u.password=:dpass")
	User getUserByEmailAndPass(@Param("email") String email, @Param("dpass") String pass);
	
	
	@Query("From User u where u.email=:email")
	User existsByEmail(@Param("email") String email);
	
	
    
}