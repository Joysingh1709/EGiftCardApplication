package com.EGiftCardApplication.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Gift_recd_details getGift_recd_detailsById(Long serialNumber) {
		Optional<Gift_recd_details> gift = giftRecdRepo.findById(serialNumber);
		if (gift.isPresent()) {
			return gift.get();
		}
		return null;
	}

	@Override
	public Gift_recd_details updateGift_recd_details(Gift_recd_details giftRecdDetails) {
		Gift_recd_details grd = giftRecdRepo.save(giftRecdDetails);
		if (grd != null) {
			return grd;
		}
		return null;
	}

}
