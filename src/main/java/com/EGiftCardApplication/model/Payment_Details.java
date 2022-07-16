package com.EGiftCardApplication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_details")
public class Payment_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payment_id;

	@Override
	public String toString() {
		return "Payment_Details [payment_id=" + payment_id + ", payment_date=" + payment_date + ", payment_amount="
				+ payment_amount + ", Nameonthecard=" + Nameonthecard + ", cardNumber=" + cardNumber + ", cardexpiry="
				+ cardexpiry + ", cvv=" + cvv + ", userGiftId=" + userGiftId + "]";
	}

	private String payment_date;
	private float payment_amount;
	private String Nameonthecard;
	private String cardNumber;
	private Date cardexpiry;
	private String cvv;
	private int userGiftId;

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

	public int getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(int userGiftId) {
		this.userGiftId = userGiftId;
	}

}
