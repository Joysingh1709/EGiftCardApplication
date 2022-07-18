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

	@ExceptionHandler(UserCustomExceptions.class)
	public ResponseEntity<Map<String, Object>> userCustomExceptionsHandler(UserCustomExceptions anf) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, anf.getMessage());
		return new ResponseEntity<>(res, anf.getStatus());
	}

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<Map<String, Object>> invalidInputExceptionHandler(InvalidInputException iie) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, iie.getMessage());
		return new ResponseEntity<>(res, iie.getStatus());
	}

}
