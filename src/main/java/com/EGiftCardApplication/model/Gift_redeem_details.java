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
	private Long gift_redeem_id;

	private boolean redeemStatus;
	private Date giftRedeemDate;
	private float giftRedeemAmount;
	private float balance;
	private Long userGiftId;

	@Override
	public String toString() {
		return "Gift_redeem_details [gift_redeem_id=" + gift_redeem_id + ", redeemStatus=" + redeemStatus
				+ ", giftRedeemDate=" + giftRedeemDate + ", giftRedeemAmount=" + giftRedeemAmount + ", balance="
				+ balance + ", userGiftId=" + userGiftId + "]";
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

	public Long getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(Long userGiftId) {
		this.userGiftId = userGiftId;
	}

}
