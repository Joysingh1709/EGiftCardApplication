package com.EGiftCardApplication.exception;

public class UserNotDeletedException extends RuntimeException{
		
		public UserNotDeletedException() {
		}
		public UserNotDeletedException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}
		public UserNotDeletedException(String message, Throwable cause) {
			super(message, cause);
		}
		public UserNotDeletedException(String message) {
			super(message);
		}
		public UserNotDeletedException(Throwable cause) {
			super(cause);
		}
		
		public UserNotDeletedException(Long userId) {
			super("User not deleted with id ---"+userId);
		}
	}


