package com.EGiftCardApplication.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.EGiftCardApplication.exception.InvalidInputException;
import com.EGiftCardApplication.exception.UserCustomExceptions;
import com.EGiftCardApplication.model.User;
import com.EGiftCardApplication.repository.UserRepository;
import com.EGiftCardApplication.util.Validations;

@Service
@Transactional
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private Validations validator;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Long userId) throws UserCustomExceptions {
		Optional<User> usr = userRepo.findById(userId);
		if (usr.isPresent()) {
			return usr.get();
		}
		throw new UserCustomExceptions("User does not exists", HttpStatus.NOT_FOUND);
	}

	@Override
	public User RegisterUser(User user) throws UserCustomExceptions, InvalidInputException {
		if (!validator.isEmailValid(user.getEmail())) {
			throw new InvalidInputException("Invalid email. Try again..!", HttpStatus.UNAUTHORIZED);
		}
		if (!validator.isPasswordValid(user.getPassword())) {
			throw new InvalidInputException("Invalid password. Try again..!", HttpStatus.UNAUTHORIZED);
		}
		User usr = userRepo.save(user);
		if (usr != null) {
			return usr;
		}
		throw new UserCustomExceptions("Cannot Register the user. Try again..!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public User UpdateUser(User user) throws UserCustomExceptions {
		User usr = userRepo.save(user);
		if (usr != null) {
			return usr;
		}
		throw new UserCustomExceptions("Cannot update the user. Try again..!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public User UpdateUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(User user) throws UserCustomExceptions {
		userRepo.delete(user);
		if (userRepo.findById(user.getUserId()).isPresent()) {
			throw new UserCustomExceptions("Error deleting the user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return "User successfully deleted..!";
	}

	@Override
	public String deleteUserById(Long userId) throws UserCustomExceptions {
		userRepo.deleteById(userId);
		if (userRepo.findById(userId).isPresent()) {
			throw new UserCustomExceptions("Error deleting the user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return "User successfully deleted..!";
	}

	@Override
	public User getUserByEmailPass(String email, String password) throws UserCustomExceptions, InvalidInputException {
		if (!validator.isEmailValid(email)) {
			throw new InvalidInputException("Invalid email. Try again..!", HttpStatus.UNAUTHORIZED);
		}
		if (!validator.isPasswordValid(password)) {
			throw new InvalidInputException("Invalid password. Try again..!", HttpStatus.UNAUTHORIZED);
		}

		User usr = userRepo.getUserByEmailAndPassword(email, password);
		if (usr != null) {
			return usr;
		}
		throw new UserCustomExceptions("Invalid email or password. Try again..!", HttpStatus.UNAUTHORIZED);
	}

	@Override
	public User updateUserPassword(String email, String oldPassword, String newPassword)
			throws UserCustomExceptions, InvalidInputException {
		User usr = userRepo.getUserWithOldPass(email, oldPassword);
		if (usr != null) {
			if (!validator.isPasswordValid(newPassword)) {
				throw new InvalidInputException("Invalid new password. Try again..!", HttpStatus.UNAUTHORIZED);
			}
			if (Objects.equals(newPassword, oldPassword)) {
				throw new InvalidInputException("old and new password cannot be same. Try again..!",
						HttpStatus.UNAUTHORIZED);
			}
			usr.setPassword(newPassword);
			return userRepo.save(usr);
		}
		throw new UserCustomExceptions("Old password is incorrect..!", HttpStatus.UNAUTHORIZED);
	}

	@Override
	public List<User> searchUsers(String searchText) {
		List<User> users = new ArrayList<>();
		if (searchText != null && !"".equals(searchText)) {
			users.addAll(userRepo.searchUsersByEmail(searchText));
			users.addAll(userRepo.searchUsersByFirstName(searchText));
			users.addAll(userRepo.searchUsersByLastName(searchText));
		}
		Set<User> set = new LinkedHashSet<>();
		set.addAll(users);
		users.clear();
		users.addAll(set);

		return users;
	}

}
