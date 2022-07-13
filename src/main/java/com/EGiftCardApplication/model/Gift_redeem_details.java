package com.EGiftCardApplication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gift_redeem_details")
public class Gift_redeem_details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gift_redeem_id;

	private boolean redeemStatus;
	private Date giftRedeemDate;
	private float giftRedeemAmount;
	private float balance;
	private int userGiftId;

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

	public int getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(int userGiftId) {
		this.userGiftId = userGiftId;
	}

	@Override
	public String toString() {
		return "Gift_redeem_details [gift_redeem_id=" + gift_redeem_id + ", redeemStatus=" + redeemStatus
				+ ", giftRedeemDate=" + giftRedeemDate + ", giftRedeemAmount=" + giftRedeemAmount + ", balance="
				+ balance + ", userGiftId=" + userGiftId + "]";
	}

}
