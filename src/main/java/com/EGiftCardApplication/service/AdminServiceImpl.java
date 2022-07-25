package com.EGiftCardApplication.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.EGiftCardApplication.model.Gift_recd_details;
import com.EGiftCardApplication.model.User_Gift_details;

public class AdminServiceImpl implements AdminService {

	@Autowired
	private GiftRecdDetailsService giftRecService;

	@Override
	public List<User_Gift_details> getUndeliveredGiftCards(String userId) {
		return null;
	}

	@Override
	public Gift_recd_details updateDeliveryStatus(Long serialNo) {
		Gift_recd_details gc = giftRecService.getGift_recd_detailsById(serialNo);
		if (gc != null) {
			gc.setGiftCardReceivedDate(new Date());
			return giftRecService.updateGift_recd_details(gc);
		}
		return null;
	}

}
