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
	private int personalizeId;

	enum personalizeType {
		birthday, Teacher, Wedding, Congratulations, Thankyou, WellDone, Love, Anniversary, MissYou
	};

	private String image;

}
