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
@Table(name = "gift_redeem_details")
public class Gift_redeem_details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long gift_redeem_id;

	private boolean redeemStatus;
	private Date giftRedeemDate;
	private float giftRedeemAmount;
	private float balance;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userGiftId")
	private User_Gift_details userGiftDetails;

	public Gift_redeem_details(boolean redeemStatus, Date giftRedeemDate, float giftRedeemAmount, float balance,
			User_Gift_details userGiftDetails) {
		super();
		this.redeemStatus = redeemStatus;
		this.giftRedeemDate = giftRedeemDate;
		this.giftRedeemAmount = giftRedeemAmount;
		this.balance = balance;
		this.userGiftDetails = userGiftDetails;
	}

	public Long getGift_redeem_id() {
		return gift_redeem_id;
	}

	public void setGift_redeem_id(Long gift_redeem_id) {
		this.gift_redeem_id = gift_redeem_id;
	}

	public boolean isRedeemStatus() {
		return redeemStatus;
	}

	public void setRedeemStatus(boolean redeemStatus) {
		this.redeemStatus = redeemStatus;
	}

	public Date getGiftRedeemDate() {
		return giftRedeemDate;
	}

	public void setGiftRedeemDate(Date giftRedeemDate) {
		this.giftRedeemDate = giftRedeemDate;
	}

	public float getGiftRedeemAmount() {
		return giftRedeemAmount;
	}

	public void setGiftRedeemAmount(float giftRedeemAmount) {
		this.giftRedeemAmount = giftRedeemAmount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public User_Gift_details getUserGiftDetails() {
		return userGiftDetails;
	}

	public void setUserGiftDetails(User_Gift_details userGiftDetails) {
		this.userGiftDetails = userGiftDetails;
	}

}
