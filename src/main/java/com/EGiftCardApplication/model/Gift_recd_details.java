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
@Table(name = "gift_recd_details")
public class Gift_recd_details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long SerialNumber;

	private Date giftCardReceivedDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userGiftId")
	private User_Gift_details userGiftDetails;

	public Gift_recd_details(Date giftCardReceivedDate, User user, User_Gift_details userGiftDetails) {
		super();
		this.giftCardReceivedDate = giftCardReceivedDate;
		this.user = user;
		this.userGiftDetails = userGiftDetails;
	}

	public Gift_recd_details() {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User_Gift_details getUserGiftDetails() {
		return userGiftDetails;
	}

	public void setUserGiftDetails(User_Gift_details userGiftDetails) {
		this.userGiftDetails = userGiftDetails;
	}

}
