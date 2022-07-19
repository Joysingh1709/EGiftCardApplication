package com.EGiftCardApplication.service;

import java.util.List;

import com.EGiftCardApplication.exception.GiftCardCustomExceptions;
import com.EGiftCardApplication.model.Gift_Card;

public interface GiftCardManagementService {
	List<Gift_Card> getAllGift_Cards();

	Gift_Card getGift_CardById(Long GiftCardId) throws GiftCardCustomExceptions;

	Gift_Card RegisterGift_Card(Gift_Card Gift_Card) throws GiftCardCustomExceptions;

	Gift_Card UpdateGift_Card(Gift_Card Gift_Card) throws GiftCardCustomExceptions;

	String deleteGift_CardById(Long GiftCardId) throws GiftCardCustomExceptions;
}
