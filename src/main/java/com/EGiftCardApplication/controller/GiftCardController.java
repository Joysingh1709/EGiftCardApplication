package com.EGiftCardApplication.controller;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EGiftCardApplication.exception.GiftCardCustomExceptions;
import com.EGiftCardApplication.exception.UserCustomExceptions;
import com.EGiftCardApplication.exception.UserGiftDetailsCustomExceptions;
import com.EGiftCardApplication.service.GiftCardManagementService;
import com.EGiftCardApplication.util.CreateResponseEntity;

@RestController()
@RequestMapping("/api/gift-card")
public class GiftCardController {

	@Autowired
	private GiftCardManagementService giftCardService;

	@GetMapping()
	public ResponseEntity<Map<String, Object>> getAllGifts() {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("these are the search results..!.");
		res.setData(giftCardService.getAllGift_Cards());
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	@PostMapping("/place-gift-order")
	public ResponseEntity<Map<String, Object>> placeGiftOrder(@RequestBody Map<String, Object> body)
			throws GiftCardCustomExceptions, UserCustomExceptions, UserGiftDetailsCustomExceptions, ParseException {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("Gift order placed successfully..!.");
		res.setData(giftCardService.RegisterGift_Card(body));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

}
