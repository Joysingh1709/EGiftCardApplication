package com.EGiftCardApplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.EGiftCardApplication.exception.UserCustomExceptions;
import com.EGiftCardApplication.exception.UserGiftDetailsCustomExceptions;
import com.EGiftCardApplication.model.User;
import com.EGiftCardApplication.model.User_Gift_details;
import com.EGiftCardApplication.repository.UserGiftDetailsAccountManagementRepository;

@Service
@Transactional
public class User_Gift_detailsAccountManagementServiceImpl implements User_Gift_detailsAccountManagementService {

	@Autowired
	private UserGiftDetailsAccountManagementRepository userGiftDetailsRepo;

	@Autowired
	private UserManagementService userRepo;

	@Override
	public List<User_Gift_details> getAllUser_Gift_details() {
		return userGiftDetailsRepo.findAll();
	}

	@Override
	public User_Gift_details getUser_Gift_details(Long userGiftdetailsId) throws UserGiftDetailsCustomExceptions {
		Optional<User_Gift_details> giftDetails = userGiftDetailsRepo.findById(userGiftdetailsId);
		if (giftDetails.isPresent()) {
			return giftDetails.get();
		}
		throw new UserGiftDetailsCustomExceptions("User gift card details not found..!", HttpStatus.NOT_FOUND);
	}

	@Override
	public User_Gift_details addUser_Gift_details(User_Gift_details userGiftdetails)
			throws UserGiftDetailsCustomExceptions {
		User_Gift_details userGiftDet = userGiftDetailsRepo.save(userGiftdetails);
		if (userGiftDet != null) {
			return userGiftDet;
		}
		throw new UserGiftDetailsCustomExceptions("User gift card details not added..!",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public User_Gift_details UpdateUser_Gift_details(User_Gift_details userGiftdetails)
			throws UserGiftDetailsCustomExceptions {
		User_Gift_details userGiftDet = userGiftDetailsRepo.save(userGiftdetails);
		if (userGiftDet != null) {
			return userGiftDet;
		}
		throw new UserGiftDetailsCustomExceptions("User gift card details not added..!",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public String deleteUser_Gift_detailsById(Long userGiftdetailsId) throws UserGiftDetailsCustomExceptions {
		userGiftDetailsRepo.deleteById(userGiftdetailsId);
		Optional<User_Gift_details> userGiftDet = userGiftDetailsRepo.findById(userGiftdetailsId);
		if (userGiftDet.isPresent()) {
			throw new UserGiftDetailsCustomExceptions("User gift card details not deleted..!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return "User gift card details deleted successfully..!";
	}

	@Override
	public List<User_Gift_details> getUserGiftOrderHistory(Long userId) throws UserCustomExceptions {
		User u = userRepo.getUserById(userId);
		return userGiftDetailsRepo.getUserGiftOrderHistory(u);
	}

}
