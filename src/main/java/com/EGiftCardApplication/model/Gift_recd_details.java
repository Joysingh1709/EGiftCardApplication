package com.EGiftCardApplication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gift_recd_details")
public class Gift_recd_details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int SerialNumber;

	private Date giftCardReceivedDate;
	private int userId;
	private int userGiftId;

	public Date getGiftCardReceivedDate() {
		return giftCardReceivedDate;
	}

	public void setGiftCardReceivedDate(Date giftCardReceivedDate) {
		this.giftCardReceivedDate = giftCardReceivedDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(int userGiftId) {
		this.userGiftId = userGiftId;
	}

	@Override
	public String toString() {
		return "Gift_recd_details [SerialNumber=" + SerialNumber + ", giftCardReceivedDate=" + giftCardReceivedDate
				+ ", userId=" + userId + ", userGiftId=" + userGiftId + "]";
	}

}
