package com.EGiftCardApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.EGiftCardApplication.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where (:firstName is null or u.firstName = :firstName)" + ""
			+ " and(:lastName is null or u.lastName = :lastName)")
	List<User> getUserByfirstLast(@Param("firstName") String firstName, @Param("lastName") String lastName);

	@Query("select u from User where (:email is null or u.email = :email)")
	 

	User getUserByEmail(@Param ("email")String email);
}
