package com.EGiftCardApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gift_card")
public class Gift_Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long giftCardId;

	private String giftCardName;
	private String brandList;

	private String redemptiondetails;
	private float minAmount = 100;
	private float maxamount = 10000;
	private String aboutGiftCard;

	public Gift_Card(String giftCardName, String brandList, String redemptiondetails, String aboutGiftCard) {
		super();
		this.giftCardName = giftCardName;
		this.brandList = brandList;
		this.redemptiondetails = redemptiondetails;
		this.aboutGiftCard = aboutGiftCard;
	}

	public Gift_Card() {
	}

	@Override
	public String toString() {
		return "Gift_Card [giftCardId=" + giftCardId + ", giftCardName=" + giftCardName + ", brandList=" + brandList
				+ ", redemptiondetails=" + redemptiondetails + ", minAmount=" + minAmount + ", maxamount=" + maxamount
				+ ", aboutGiftCard=" + aboutGiftCard + "]";
	}

	public Long getGiftCardId() {
		return giftCardId;
	}

	public void setGiftCardId(Long giftCardId) {
		this.giftCardId = giftCardId;
	}

	public String getGiftCardName() {
		return giftCardName;
	}

	public void setGiftCardName(String giftCardName) {
		this.giftCardName = giftCardName;
	}

	public String getBrandList() {
		return brandList;
	}

	public void setBrandList(String brandList) {
		this.brandList = brandList;
	}

	public String getRedemptiondetails() {
		return redemptiondetails;
	}

	public void setRedemptiondetails(String redemptiondetails) {
		this.redemptiondetails = redemptiondetails;
	}

	public float getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(float minAmount) {
		this.minAmount = minAmount;
	}

	public float getMaxamount() {
		return maxamount;
	}

	public void setMaxamount(float maxamount) {
		this.maxamount = maxamount;
	}

	public String getAboutGiftCard() {
		return aboutGiftCard;
	}

	public void setAboutGiftCard(String aboutGiftCard) {
		this.aboutGiftCard = aboutGiftCard;
	}

}
