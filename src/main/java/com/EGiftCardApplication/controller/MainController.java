package com.EGiftCardApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/email")
	public String sendEmail() {
		return notifService.sendDemoNotif();
	}

}
