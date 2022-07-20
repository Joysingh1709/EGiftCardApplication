package com.EGiftCardApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.EGiftCardApplication.model.User;
import com.EGiftCardApplication.model.User_Gift_details;

public interface UserGiftDetailsAccountManagementRepository extends JpaRepository<User_Gift_details, Long> {

	@Query("Select gfd From User_Gift_details gfd WHERE gfd.user =:user")
	List<User_Gift_details> getUserGiftOrderHistory(@Param("user") User user);

}
