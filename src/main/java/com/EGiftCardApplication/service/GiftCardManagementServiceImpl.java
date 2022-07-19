package com.EGiftCardApplication.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.EGiftCardApplication.exception.GiftCardCustomExceptions;
import com.EGiftCardApplication.exception.UserCustomExceptions;
import com.EGiftCardApplication.exception.UserGiftDetailsCustomExceptions;
import com.EGiftCardApplication.model.Gift_Card;
import com.EGiftCardApplication.model.Gift_recd_details;
import com.EGiftCardApplication.model.Personalize;
import com.EGiftCardApplication.model.User;
import com.EGiftCardApplication.model.User_Gift_details;
import com.EGiftCardApplication.repository.GiftCardManagementRepository;

@Service
@Transactional
public class GiftCardManagementServiceImpl implements GiftCardManagementService {

	@Autowired
	private GiftCardManagementRepository giftCardRepo;

	@Autowired
	private UserManagementService userService;

	@Autowired
	private User_Gift_detailsAccountManagementService userGiftDetailsService;

	@Autowired
	private GiftRecdDetailsService giftRecdService;

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
	public Gift_Card RegisterGift_Card(Map<String, Object> giftCard)
			throws GiftCardCustomExceptions, UserCustomExceptions, UserGiftDetailsCustomExceptions, ParseException {

		Gift_Card gc = giftCardRepo.save(new Gift_Card(giftCard.get("giftCardName").toString(),
				giftCard.get("brandList").toString(),
				"This eGift Card will be activated within 48 hours from the time of purchase.\r\n"
						+ "Redeemable at 80+ Brands.\r\n" + "Terms & Conditions of retail partners are applicable.",
				giftCard.get("aboutGiftCard").toString()));

		if (gc != null) {

			// new Personalization
			Personalize pz = new Personalize("");
			// user who is buying the gift card
			User u = userService.getUserById(Long.valueOf(giftCard.get("userId").toString()));

			User_Gift_details userGiftDet = new User_Gift_details();
			userGiftDet.setUser(u);
			userGiftDet.setGiftCard(gc);
			userGiftDet.setGiftCardAmount(Integer.valueOf(giftCard.get("giftCardAmount").toString()).floatValue());
			userGiftDet.setGiftCardIssueDate(
					new SimpleDateFormat("dd/MM/yyyy").parse(giftCard.get("giftCardIssueDate").toString()));
			userGiftDet.setReloadable((boolean) giftCard.get("reloadable"));
			userGiftDet.setRecipientsName(giftCard.get("RecipientsName").toString());
			userGiftDet.setRecipientsMobileNumber(giftCard.get("RecipientsMobileNumber").toString());
			userGiftDet.setRecipientsEmail(giftCard.get("RecipientsEmail").toString());
			userGiftDet.setDelivaryType(giftCard.get("delivaryType").toString());
			userGiftDet.setScheduledelivary(LocalDate.parse(giftCard.get("scheduledelivary").toString(),
					DateTimeFormatter.ofPattern("d/MM/yyyy")));
			userGiftDet.setPersonalize(pz);

			User_Gift_details savedUserGiftDet = userGiftDetailsService.addUser_Gift_details(userGiftDet);

			if (savedUserGiftDet != null) {

				// new gift card record details
				Gift_recd_details giftRecd = new Gift_recd_details();
				giftRecd.setGiftCardReceivedDate(null);
				giftRecd.setUser(u);
				giftRecd.setUserGiftDetails(savedUserGiftDet);

				Gift_recd_details newgrd = giftRecdService.addGift_recd_details(giftRecd);
				if (newgrd != null) {
					return gc;
				}
				throw new GiftCardCustomExceptions("Error Adding gift card record details. Try again..!",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			throw new GiftCardCustomExceptions("Error saving User Gift detials. Try again..!",
					HttpStatus.INTERNAL_SERVER_ERROR);
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
