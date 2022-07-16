package com.EGiftCardApplication.service;

import java.util.List;

import com.EGiftCardApplication.model.Gift_Card;

public interface GiftCardManagementService {
	List<Gift_Card> getAllGift_Cards();

	Gift_Card getGift_CardById(int GiftCardId);

	Gift_Card RegisterGift_Card(Gift_Card Gift_Card);

	Gift_Card UpdateGift_Card(Gift_Card Gift_Card);

	Gift_Card UpdateGift_CardById(int GiftCardId);

	String deleteGift_Card(Gift_Card Gift_Card);

	String deleteGift_CardById(int GiftCardId);
}
