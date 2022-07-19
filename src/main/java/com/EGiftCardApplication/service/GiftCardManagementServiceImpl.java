package com.EGiftCardApplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.EGiftCardApplication.exception.GiftCardCustomExceptions;
import com.EGiftCardApplication.model.Gift_Card;
import com.EGiftCardApplication.repository.GiftCardManagementRepository;

@Service
@Transactional
public class GiftCardManagementServiceImpl implements GiftCardManagementService {

	@Autowired
	private GiftCardManagementRepository giftCardRepo;

	@Override
	public List<Gift_Card> getAllGift_Cards() {
		return giftCardRepo.findAll();
	}

	@Override
	public Gift_Card getGift_CardById(Long giftCardId) throws GiftCardCustomExceptions {
		Optional<Gift_Card> gc = giftCardRepo.findById(giftCardId);
		if (gc.isPresent()) {
			return gc.get();
		}
		throw new GiftCardCustomExceptions("No Gift card Exists with id: " + giftCardId, HttpStatus.NOT_FOUND);
	}

	@Override
	public Gift_Card RegisterGift_Card(Gift_Card giftCard) throws GiftCardCustomExceptions {
		Gift_Card gc = giftCardRepo.save(giftCard);
		if (gc != null) {
			return gc;
		}
		throw new GiftCardCustomExceptions("Error placing order for gift card. Try again..!",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public Gift_Card UpdateGift_Card(Gift_Card giftCard) throws GiftCardCustomExceptions {
		Gift_Card gc = giftCardRepo.save(giftCard);
		if (gc != null) {
			return gc;
		}
		throw new GiftCardCustomExceptions("Error updating gift card. Try again..!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public String deleteGift_CardById(Long giftCard) throws GiftCardCustomExceptions {
		giftCardRepo.deleteById(giftCard);
		Optional<Gift_Card> gc = giftCardRepo.findById(giftCard);
		if (gc.isPresent()) {
			throw new GiftCardCustomExceptions("Error updating gift card. Try again..!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return "Gift card deleted successfully";
	}

}
