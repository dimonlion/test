package com.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.MailForDeliveryDAO;
import com.onlineshop.model.MailForDelivery;
import com.onlineshop.service.MailForDeliveryService;

@Service
public class MailForDeliveryServiceImpl implements MailForDeliveryService{

	private static final int PAGE_ELEMENT_SIZE=3;
	
	@Autowired
	private MailForDeliveryDAO mailForDeliverDAO;
	
	@Override
	@Transactional
	public void addMail(MailForDelivery mail) {
		mailForDeliverDAO.save(mail);
		
	}

	@Override
	@Transactional
	public Page<MailForDelivery> showAllMails(Integer pageNumber) {
	
		PageRequest page = new PageRequest(pageNumber-1, PAGE_ELEMENT_SIZE);
		return mailForDeliverDAO.findAll(page);
	}

	
}
