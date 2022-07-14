package com.EGiftCardApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.EGiftCardApplication.model.Gift_recd_details;
import com.EGiftCardApplication.model.Gift_redeem_details;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private JavaMailSender emailSender;

	@Override
	public List<Gift_recd_details> getAllGift_recd_details() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gift_redeem_details> getAllGift_redeem_details() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gift_redeem_details sendGift_redeem_detailsNotification(Gift_redeem_details gift_redeem_details) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gift_recd_details sendGift_recd_detailsNotification(Gift_recd_details gift_recd_details) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendDemoNotif() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("hgacc262@gmail.com");
		message.setTo("joy70013@gmail.com");
		message.setSubject("E Gift Card App");
		message.setText("This is a System generated mail.\nPlease do not reply back..!");
		emailSender.send(message);
		return "Email Sent..!";
	}

}
