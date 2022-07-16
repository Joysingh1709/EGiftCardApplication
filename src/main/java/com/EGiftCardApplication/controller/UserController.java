package com.EGiftCardApplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/user")
public class UserController {
	
	
	@PostMapping("/register")
	public ResponseEntity<Map<String,Object>> userRegister(@RequestBody Map<String,Object> body){
		Map<String,Object> res = new HashMap<>();
		res.put("Status",true);
		res.put("message", "User Data Inserted Sucessfully");
		res.put("data", body);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
