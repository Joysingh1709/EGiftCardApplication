package com.EGiftCardApplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EGiftCardApplication.model.User;
import com.EGiftCardApplication.service.UserManagementService;

@RestController()
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserManagementService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Map<String,Object>> userRegister(@RequestBody User user){
		Map<String,Object> res = new HashMap<>();
		res.put("Status",true);
		res.put("message", "User Data Inserted Sucessfully");
		res.put("data", userService.RegisterUser(user));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
