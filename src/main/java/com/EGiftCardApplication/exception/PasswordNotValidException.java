package com.EGiftCardApplication.exception;
public class PasswordNotValidException extends Exception {

	public PasswordNotValidException() {
	}

	public PasswordNotValidException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PasswordNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordNotValidException(String message) {
		super(message);
	}

	public PasswordNotValidException(Throwable cause) {
		super(cause);
	}

}