package com.EGiftCardApplication.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EGiftCardApplication.model.Gift_recd_details;
import com.EGiftCardApplication.repository.GiftRecdDetailsRepository;

@Service
@Transactional
public class GiftRecdDetailsServiceImpl implements GiftRecdDetailsService {

	@Autowired
	private GiftRecdDetailsRepository giftRecdRepo;

	@Override
	public List<Gift_recd_details> getAllGift_recd_details() {
		return giftRecdRepo.findAll();
	}

	@Override
	public Gift_recd_details addGift_recd_details(Gift_recd_details giftRecdDetails) {
		Gift_recd_details grd = giftRecdRepo.save(giftRecdDetails);
		if (grd != null) {
			return grd;
		}
		return null;
	}

}
