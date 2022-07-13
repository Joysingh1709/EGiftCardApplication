package com.EGiftCardApplication.service;

import java.util.List;
import com.EGiftCardApplication.model.User;

public interface UserManagementService {
	
	List<User> getAllUsers();
	User getUserById(int userId);
	User RegisterUser(User user);
	User UpdateUser(User user);
	User UpdateUserById(int userId);
	String deleteUser(User user);
	String deleteUserById(int userId);
}
