package com.EGiftCardApplication.service;

import java.util.List;
import com.EGiftCardApplication.model.User;

public interface UserManagementService {

	List<User> getAllUsers();

	List<User> getUserByfirstLast(String firstName, String lastName);
	
	User getUserByEmail(String email);

	User RegisterUser(User user);

	User UpdateUser(User user);

	User UpdateUserById(int userId);

	String deleteUser(User user);

	String deleteUserById(int userId);
}
