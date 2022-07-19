package com.EGiftCardApplication.model;

import java.time.LocalDate;
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
@Table(name = "user_gift_details")
public class User_Gift_details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userGiftId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "giftCardId")
	private Gift_Card giftCard;

	private float giftCardAmount;
	private Date giftCardIssueDate;
	private boolean reloadable;
	private String RecipientsName;
	private String RecipientsMobileNumber;
	private String RecipientsEmail;
	private String delivaryType;
	private LocalDate scheduledelivary;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personalizeId")
	private Personalize personalize;

	public User_Gift_details(User user, Gift_Card giftCard, float giftCardAmount, Date giftCardIssueDate,
			boolean reloadable, String recipientsName, String recipientsMobileNumber, String recipientsEmail,
			String delivaryType, LocalDate scheduledelivary, Personalize personalize) {
		super();
		this.user = user;
		this.giftCard = giftCard;
		this.giftCardAmount = giftCardAmount;
		this.giftCardIssueDate = giftCardIssueDate;
		this.reloadable = reloadable;
		this.RecipientsName = recipientsName;
		this.RecipientsMobileNumber = recipientsMobileNumber;
		this.RecipientsEmail = recipientsEmail;
		this.delivaryType = delivaryType;
		this.scheduledelivary = scheduledelivary;
		this.personalize = personalize;
	}

	public User_Gift_details() {
	}

	public Long getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(Long userGiftId) {
		this.userGiftId = userGiftId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Gift_Card getGiftCard() {
		return giftCard;
	}

	public void setGiftCard(Gift_Card giftCard) {
		this.giftCard = giftCard;
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

	public Personalize getPersonalize() {
		return personalize;
	}

	public void setPersonalize(Personalize personalize) {
		this.personalize = personalize;
	}

}
