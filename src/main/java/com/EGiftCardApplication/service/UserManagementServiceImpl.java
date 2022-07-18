package com.EGiftCardApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.EGiftCardApplication.model.User;
import com.EGiftCardApplication.repository.UserRepository;

public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public List<User> getUserByfirstLast(String firstName, String lastName) {
		List<User> customers = userRepository.getUserByfirstLast(firstName, lastName);

		if (customers.size() > 0) {
			return customers;
		} else {
			return new ArrayList<User>();
		}
	}
	
	@Override
	public User getUserByEmail(String email) {
		User user = userRepository.getUserByEmail(email);
        return user;
	}
	
	@Override
	public User RegisterUser(User user) {
		return userRepository.save(user);

	}

	@Override
	public User UpdateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User UpdateUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
