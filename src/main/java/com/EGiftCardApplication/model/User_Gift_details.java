package com.EGiftCardApplication.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_gift_details")
public class User_Gift_details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userGiftId;

	private int userId;
	private int giftCardId;
	private float giftCardAmount;
	private Date giftCardIssueDate;
	private boolean reloadable;
	private String RecipientsName;
	private String RecipientsMobileNumber;
	private String RecipientsEmail;
	private String delivaryType;
	private LocalDate scheduledelivary;
	private int personalizeId;

	@Override
	public String toString() {
		return "User_Gift_details [userGiftId=" + userGiftId + ", userId=" + userId + ", giftCardId=" + giftCardId
				+ ", giftCardAmount=" + giftCardAmount + ", giftCardIssueDate=" + giftCardIssueDate + ", reloadable="
				+ reloadable + ", RecipientsName=" + RecipientsName + ", RecipientsMobileNumber="
				+ RecipientsMobileNumber + ", RecipientsEmail=" + RecipientsEmail + ", delivaryType=" + delivaryType
				+ ", scheduledelivary=" + scheduledelivary + ", personalizeId=" + personalizeId + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGiftCardId() {
		return giftCardId;
	}

	public void setGiftCardId(int giftCardId) {
		this.giftCardId = giftCardId;
	}

	public float getGiftCardAmount() {
		return giftCardAmount;
	}

	public void setGiftCardAmount(float giftCardAmount) {
		this.giftCardAmount = giftCardAmount;
	}

	public Date getGiftCardIssueDate() {
		return giftCardIssueDate;
	}

	public void setGiftCardIssueDate(Date giftCardIssueDate) {
		this.giftCardIssueDate = giftCardIssueDate;
	}

	public boolean isReloadable() {
		return reloadable;
	}

	public void setReloadable(boolean reloadable) {
		this.reloadable = reloadable;
	}

	public String getRecipientsName() {
		return RecipientsName;
	}

	public void setRecipientsName(String recipientsName) {
		RecipientsName = recipientsName;
	}

	public String getRecipientsMobileNumber() {
		return RecipientsMobileNumber;
	}

	public void setRecipientsMobileNumber(String recipientsMobileNumber) {
		RecipientsMobileNumber = recipientsMobileNumber;
	}

	public String getRecipientsEmail() {
		return RecipientsEmail;
	}

	public void setRecipientsEmail(String recipientsEmail) {
		RecipientsEmail = recipientsEmail;
	}

	public String getDelivaryType() {
		return delivaryType;
	}

	public void setDelivaryType(String delivaryType) {
		this.delivaryType = delivaryType;
	}

	public LocalDate getScheduledelivary() {
		return scheduledelivary;
	}

	public void setScheduledelivary(LocalDate scheduledelivary) {
		this.scheduledelivary = scheduledelivary;
	}

	public int getPersonalizeId() {
		return personalizeId;
	}

	public void setPersonalizeId(int personalizeId) {
		this.personalizeId = personalizeId;
	}
}
