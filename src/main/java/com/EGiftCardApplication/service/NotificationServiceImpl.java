package com.EGiftCardApplication.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.EGiftCardApplication.model.Gift_recd_details;
import com.EGiftCardApplication.model.Gift_redeem_details;
import com.EGiftCardApplication.util.NotificationUtils;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private NotificationUtils notifUtil;

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
	public String sendDemoNotif(String email, String firstname, String lastName, String type)
			throws MessagingException, UnsupportedEncodingException {
		String html;

		switch (type) {
		case "register":
			html = notifUtil.sendMailOnUserRegister(firstname, lastName);
			break;
		case "update":
			html = notifUtil.sendMailOnUserUpdate(firstname, lastName);
			break;
		case "purchase":
			html = notifUtil.sendMailOnGiftCardPurchase(firstname, lastName);
			break;
		case "redeem":
			html = notifUtil.sendMailOnGiftCardRedeemed(firstname, lastName);
			break;
		case "recieve":
			html = notifUtil.sendMailOnGiftCardRecieved(firstname, lastName);
			break;
		default:
			html = notifUtil.simpleMailTemplate(email, firstname, lastName);
		}

		MimeMessage helper = emailSender.createMimeMessage();
		MimeMessageHelper msg = new MimeMessageHelper(helper);

		msg.setFrom("hgacc262@gmail.com", "E-GiftCard");
		msg.setTo(email);
		msg.setSubject("E Gift Card App");
		msg.setText(html, true);
		emailSender.send(helper);
		return "Email Sent..!";
	}

	@Override
	public String sendOnRegisterMail(String email, String firstname, String lastName)
			throws UnsupportedEncodingException, MessagingException {
		String html = notifUtil.sendMailOnUserRegister(firstname, lastName);

		MimeMessage helper = emailSender.createMimeMessage();
		MimeMessageHelper msg = new MimeMessageHelper(helper);

		msg.setFrom("hgacc262@gmail.com", "E-GiftCard");
		msg.setTo("avnishmamta060606@gmail.com");
		msg.setSubject("E Gift Card App");
		msg.setText(html, true);
		emailSender.send(helper);
		return "Email Sent..!";
	}

}
