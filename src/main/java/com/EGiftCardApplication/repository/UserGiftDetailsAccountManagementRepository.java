package com.EGiftCardApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EGiftCardApplication.model.User_Gift_details;

public interface UserGiftDetailsAccountManagementRepository extends JpaRepository<User_Gift_details, Long> {

}
