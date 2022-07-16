package com.EGiftCardApplication.service;

import java.util.List;

import com.EGiftCardApplication.model.Payment_Details;

public interface PaymentService {

	List<Payment_Details> getAllPayment_Details();

	Payment_Details getPayment_DetailsById(int Payment_id);

	Payment_Details RegisterPayment_Details(Payment_Details Payment_Details);

	Payment_Details UpdatePayment_Details(Payment_Details Payment_Details);

	Payment_Details UpdatePayment_DetailsById(int Payment_id);

	String deletePayment_Details(Payment_Details Payment_Details);

	String deletePayment_DetailsById(int Payment_id);

}
