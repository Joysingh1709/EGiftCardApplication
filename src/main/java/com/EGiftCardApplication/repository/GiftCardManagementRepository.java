package com.EGiftCardApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EGiftCardApplication.model.Gift_Card;

public interface GiftCardManagementRepository extends JpaRepository<Gift_Card, Long> {

}
