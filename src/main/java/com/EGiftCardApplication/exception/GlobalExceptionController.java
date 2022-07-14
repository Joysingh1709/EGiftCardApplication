package com.EGiftCardApplication.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {
	
	private static final String status = "status";
	private static final String message = "message";
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, Object>> adminNotFoundHandler(UserNotFoundException anf) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, anf.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

}
