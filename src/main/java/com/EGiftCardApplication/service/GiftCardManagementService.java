package com.EGiftCardApplication.service;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import com.EGiftCardApplication.exception.GiftCardCustomExceptions;
import com.EGiftCardApplication.exception.InvalidInputException;
import com.EGiftCardApplication.exception.UserCustomExceptions;
import com.EGiftCardApplication.exception.UserGiftDetailsCustomExceptions;
import com.EGiftCardApplication.model.Gift_Card;

public interface GiftCardManagementService {
	List<Gift_Card> getAllGift_Cards();

	Gift_Card getGift_CardById(Long GiftCardId) throws GiftCardCustomExceptions;

	Gift_Card RegisterGift_Card(Map<String, Object> giftCardDetails)
			throws GiftCardCustomExceptions, UserCustomExceptions, UserGiftDetailsCustomExceptions, ParseException,
			UnsupportedEncodingException, MessagingException, InvalidInputException;

	Gift_Card UpdateGift_Card(Gift_Card Gift_Card) throws GiftCardCustomExceptions;

	String deleteGift_CardById(Long GiftCardId) throws GiftCardCustomExceptions;
}
