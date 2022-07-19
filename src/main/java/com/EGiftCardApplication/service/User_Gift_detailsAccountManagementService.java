package com.EGiftCardApplication.service;

import java.util.List;

import com.EGiftCardApplication.exception.UserGiftDetailsCustomExceptions;
import com.EGiftCardApplication.model.User_Gift_details;

public interface User_Gift_detailsAccountManagementService {

	List<User_Gift_details> getAllUser_Gift_details();

	User_Gift_details getUser_Gift_details(Long userGiftDetailsId) throws UserGiftDetailsCustomExceptions;

	User_Gift_details addUser_Gift_details(User_Gift_details userGiftDetails) throws UserGiftDetailsCustomExceptions;

	User_Gift_details UpdateUser_Gift_details(User_Gift_details userGiftDetails) throws UserGiftDetailsCustomExceptions;

	String deleteUser_Gift_detailsById(Long userGiftDetailsId) throws UserGiftDetailsCustomExceptions;

}
