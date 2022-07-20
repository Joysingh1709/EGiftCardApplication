package com.EGiftCardApplication.service;

import java.util.List;

import com.EGiftCardApplication.model.Gift_recd_details;
import com.EGiftCardApplication.model.User_Gift_details;

public interface AdminService {
	public List<User_Gift_details> getUndeliveredGiftCards(String userId);

	public Gift_recd_details updateDeliveryStatus(Long serialNo);
}
