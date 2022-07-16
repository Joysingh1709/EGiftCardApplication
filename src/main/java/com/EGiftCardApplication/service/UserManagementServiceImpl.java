package com.EGiftCardApplication.service;

import java.util.*;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Validation;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.EGiftCardApplication.dao.UserRepository;
import com.EGiftCardApplication.model.User;
import com.EGiftCardApplication.exception.*;
import com.EGiftCardApplication.utils.*;

@Service
@Transactional
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	UserRepository userRepositary;

	@Override
	public List<User> getAllUsers() {
		return userRepositary.findAll();
	}

	/*
	 * @Override public User getUser(String email, String password) throws
	 * UserNotFoundException, EmailNotValidException, PasswordNotValidException { {
	 * if (!Validation.isEmailValid(email)) { throw new
	 * EmailNotValidException("Please provide a valid email address..!"); }
	 * 
	 * if (!Validation.isPasswordValid(password)) { throw new
	 * PasswordNotValidException("Please provide a valid Password..!"); }
	 * 
	 * User usr = UserRepository.findBy(email, password); if (usr != null) { return
	 * usr; } throw new UserNotFoundException("Email or password is incorrect..!");
	 * }
	 * 
	 * //return null; }
	 */

	@Override
	public User getUserById(Long userId) throws UserNotFoundException {
		Optional<User> user = userRepositary.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
		throw new UserNotFoundException("no user found");
	}

	@Override
	public User RegisterUser(User user) {
		return null;
	}

	@Override
	public User UpdateUser(User user) {
		if (userRepositary.existsById(user.getUserId())) {
			User usr = userRepositary.save(user);
			return usr;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteUser(User user) throws UserNotDeletedException {
		// TODO Auto-generated method stub
		userRepositary.delete(user);
		if (userRepositary.existsById(user.getUserId())) {
			throw new UserNotDeletedException("error while deleting user");
		}
		return true;

	}

	@Override
	public boolean deleteUserById(Long userId) throws UserNotDeletedException {
		// TODO Auto-generated method stub
		userRepositary.deleteById(userId);
		if (userRepositary.existsById(userId)) {
			throw new UserNotDeletedException("user is not deleted");
		}
		return true;

	}

	@Override
	public User getUser(String email, String password)
			throws UserNotFoundException, EmailNotValidException, PasswordNotValidException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User UpdateUserById(Long userId) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		User usr = userRepositary.existsByEmail(email);
		if (usr != null){
			return usr;
		} 
		return null;
	}
}
