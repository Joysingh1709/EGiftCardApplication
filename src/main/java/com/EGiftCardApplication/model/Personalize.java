package com.EGiftCardApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personalize")
public class Personalize {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long personalizeId;

	enum personalizeType {
		birthday, Teacher, Wedding, Congratulations, Thankyou, WellDone, Love, Anniversary, MissYou
	};

	private String image;

	public Personalize(String image) {
		super();
		this.image = image;
	}

	public Personalize() {
	}

	public Long getPersonalizeId() {
		return personalizeId;
	}

	public void setPersonalizeId(Long personalizeId) {
		this.personalizeId = personalizeId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
