package com.EGiftCardApplication.service;

import java.util.List;

import com.EGiftCardApplication.exception.EmailNotValidException;
import com.EGiftCardApplication.exception.PasswordNotValidException;
import com.EGiftCardApplication.exception.UserNotFoundException;
import com.EGiftCardApplication.model.User;

public interface UserManagementService {

	List<User> getAllUsers();

	User getUserById(Long userId);

	User RegisterUser(User user);

	User UpdateUser(User user);

	User UpdateUserById(Long userId);
	
	User getUserByEmail(String email);

	boolean deleteUser(User user);

	boolean deleteUserById(Long userId);

	User getUser(String email, String password)
			throws UserNotFoundException, EmailNotValidException, PasswordNotValidException;

}
