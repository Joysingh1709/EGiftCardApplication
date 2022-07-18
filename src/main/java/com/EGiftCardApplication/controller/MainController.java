package com.EGiftCardApplication.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EGiftCardApplication.service.NotificationService;

@RestController()
public class MainController {

	@Autowired
	private NotificationService notifService;

	@GetMapping()
	public String welcome() {
		return "Hello from E-GiftCard Application";
	}

	@PostMapping("/send-email")
	public String sendEmail(@RequestBody Map<String, Object> body)
			throws MessagingException, UnsupportedEncodingException {
		return notifService.sendOnRegisterMail(body.get("email").toString(), body.get("firstName").toString(),
				body.get("lastName").toString());
	}

}
