package com.EGiftCardApplication.service;

import java.util.List;

import com.EGiftCardApplication.exception.InvalidInputException;
import com.EGiftCardApplication.exception.UserCustomExceptions;
import com.EGiftCardApplication.model.User;

public interface UserManagementService {

	List<User> getAllUsers();

	User getUserByEmailPass(String email, String password) throws UserCustomExceptions, InvalidInputException;

	User updateUserPassword(String email, String oldPassword, String newPassword) throws UserCustomExceptions, InvalidInputException;

	List<User> searchUsers(String searchText);

	User getUserById(Long userId) throws UserCustomExceptions;

	User RegisterUser(User user) throws UserCustomExceptions, InvalidInputException;

	User UpdateUser(User user) throws UserCustomExceptions;

	User UpdateUserById(Long userId);

	String deleteUser(User user) throws UserCustomExceptions;

	String deleteUserById(Long userId) throws UserCustomExceptions;
}
