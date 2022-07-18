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
	private Long SerialNumber;

	private Date giftCardReceivedDate;
	private Long userId;
	private Long userGiftId;

	@Override
	public String toString() {
		return "Gift_recd_details [SerialNumber=" + SerialNumber + ", giftCardReceivedDate=" + giftCardReceivedDate
				+ ", userId=" + userId + ", userGiftId=" + userGiftId + "]";
	}

	public Long getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(Long serialNumber) {
		SerialNumber = serialNumber;
	}

	public Date getGiftCardReceivedDate() {
		return giftCardReceivedDate;
	}

	public void setGiftCardReceivedDate(Date giftCardReceivedDate) {
		this.giftCardReceivedDate = giftCardReceivedDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(Long userGiftId) {
		this.userGiftId = userGiftId;
	}

}
