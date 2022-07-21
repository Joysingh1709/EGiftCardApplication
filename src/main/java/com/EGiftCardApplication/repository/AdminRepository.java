package com.EGiftCardApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.EGiftCardApplication.model.Gift_Card;

public interface AdminRepository {
//extends JpaRepository<Gift_Card, Long>{

//	@Query("Select gift_card_id,gift_card_name,brand_list,redemtion_details,minimum_amount,maximum_amount,about_gift_card from (gift_recieved_details as grd INNER JOIN user_gift_details as ugd ON "
//			+ "grd.user_gift_id = ugd.user_gift_id and grd.gift_recieved_date IS NULL) INNER JOIN "
//			+ "gift_card USING(gift_card_id);")
//	List<Gift_Card> getAllUndeliveredCards();

}
