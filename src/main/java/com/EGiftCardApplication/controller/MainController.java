package com.EGiftCardApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EGiftCardApplication.exception.EmailNotValidException;
import com.EGiftCardApplication.exception.PasswordNotValidException;
import com.EGiftCardApplication.exception.UserNotFoundException;
import com.EGiftCardApplication.model.User;
import com.EGiftCardApplication.service.NotificationService;
import com.EGiftCardApplication.service.UserManagementService;
import com.EGiftCardApplication.service.UserManagementServiceImpl;

@RestController()
public class MainController {

	@Autowired
	private NotificationService notifService;

	@Autowired
	private UserManagementService usermanagementservice;

	private static final String status = "status";
	private static final String message = "message";

	@GetMapping()
	public String welcome() {
		return "Hello from E-GiftCard Application";
	}

	@PostMapping("/email")
	public String sendEmail() {
		return notifService.sendDemoNotif();
	}

	@PostMapping("/api/login")
	public ResponseEntity<Map<String, Object>> Login(@RequestBody Map<String, Object> body) throws UserNotFoundException, EmailNotValidException, PasswordNotValidException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data inserted successfully!");
		res.put("data",	usermanagementservice.getUser(body.get("email").toString(), body.get("password").toString()));

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/api/users/userProfile")
	public ResponseEntity<Map<String, Object>> getUserProfile(@RequestBody  Map<String, Object> body) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data inserted successfully!");
		res.put("data",usermanagementservice.getUserByEmail(body.get("email").toString()));
		
		return new ResponseEntity<>(res,HttpStatus.OK);

		
	}

	@PutMapping(path = "/api/users/changePassword", consumes = { "application/json" })
	public ResponseEntity<Map<String, Object>> ChangePassword(@RequestBody User user) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Password changed successfully..!!");
		res.put("data",	usermanagementservice);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	/*
	 * 
	 * @PostMapping("/users/logout") public Status loguserOut(@RequestBody User
	 * user) { List<User> users = user.findAll(); for(User other : users) {
	 * if(other.equals(user) && other.getLoginstatus()==1) { user.setLoginstatus(0);
	 * if(user.getUserID().equals("admin123")) { user.setUsertype("A"); } else {
	 * user.setUsertype("C"); } user.save(user); return Status.Logout_Successfully;
	 * } } return Status.Failure; }
	 */

}