package com.EGiftCardApplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EGiftCardApplication.exception.InvalidInputException;
import com.EGiftCardApplication.exception.UserCustomExceptions;
import com.EGiftCardApplication.model.User;
import com.EGiftCardApplication.service.UserManagementService;
import com.EGiftCardApplication.util.CreateResponseEntity;

@RestController()
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserManagementService userService;

	@GetMapping()
	public ResponseEntity<Map<String, Object>> getAllUsers() {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("list of users fetched successfully.");
		res.setData(userService.getAllUsers());
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> userLogin(@RequestBody User user)
			throws UserCustomExceptions, InvalidInputException {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("user registered successfully.");
		res.setData(userService.RegisterUser(user));
		res.setHttpStatus(HttpStatus.CREATED);
		return res.getResponseEntity();
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> userLogin(@RequestBody Map<String, Object> body)
			throws UserCustomExceptions, InvalidInputException {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("Login successfull.");
		res.setData(userService.getUserByEmailPass(body.get("email").toString(), body.get("password").toString()));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	@GetMapping("/{userId}/profile")
	public ResponseEntity<Map<String, Object>> userProfile(@PathVariable Long userId) throws UserCustomExceptions {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("profile fetched successfully.");
		res.setData(userService.getUserById(userId));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	@PostMapping("/search")
	public ResponseEntity<Map<String, Object>> usersSearch(@RequestBody Map<String, Object> body) {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("these are the search results..!.");
		res.setData(userService.searchUsers(body.get("searchText").toString()));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	@PostMapping("/change-password")
	public ResponseEntity<Map<String, Object>> changePassword(@RequestBody Map<String, Object> body)
			throws UserCustomExceptions, InvalidInputException {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("these are the search results..!.");
		res.setData(userService.updateUserPassword(body.get("email").toString(), body.get("oldPassword").toString(),
				body.get("newPassword").toString()));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

}
