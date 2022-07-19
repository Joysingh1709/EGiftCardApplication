package com.EGiftCardApplication.service;

import java.util.List;

import com.EGiftCardApplication.model.Gift_recd_details;

public interface GiftRecdDetailsService {

	public List<Gift_recd_details> getAllGift_recd_details();

	public Gift_recd_details addGift_recd_details(Gift_recd_details giftRecdDetails);

}
