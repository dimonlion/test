package com.onlineshop.service;

import org.springframework.data.domain.Page;

import com.onlineshop.model.MailForDelivery;

public interface MailForDeliveryService {

	void addMail(MailForDelivery mail);
	Page<MailForDelivery> showAllMails(Integer pageNumber);
}
