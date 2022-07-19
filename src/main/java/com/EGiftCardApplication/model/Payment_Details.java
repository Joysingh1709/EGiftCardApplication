package com.EGiftCardApplication.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment_details")
public class Payment_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long payment_id;

	private String payment_date;
	private float payment_amount;
	private String Nameonthecard;
	private String cardNumber;
	private Date cardexpiry;
	private String cvv;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userGiftId")
	private User_Gift_details userGiftDetails;

	public Payment_Details(String payment_date, float payment_amount, String nameonthecard, String cardNumber,
			Date cardexpiry, String cvv, User_Gift_details userGiftDetails) {
		super();
		this.payment_date = payment_date;
		this.payment_amount = payment_amount;
		Nameonthecard = nameonthecard;
		this.cardNumber = cardNumber;
		this.cardexpiry = cardexpiry;
		this.cvv = cvv;
		this.userGiftDetails = userGiftDetails;
	}

	public Long getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public float getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(float payment_amount) {
		this.payment_amount = payment_amount;
	}

	public String getNameonthecard() {
		return Nameonthecard;
	}

	public void setNameonthecard(String nameonthecard) {
		Nameonthecard = nameonthecard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getCardexpiry() {
		return cardexpiry;
	}

	public void setCardexpiry(Date cardexpiry) {
		this.cardexpiry = cardexpiry;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public User_Gift_details getUserGiftDetails() {
		return userGiftDetails;
	}

	public void setUserGiftDetails(User_Gift_details userGiftDetails) {
		this.userGiftDetails = userGiftDetails;
	}

}
