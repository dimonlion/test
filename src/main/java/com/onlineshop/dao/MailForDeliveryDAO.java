package com.onlineshop.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.model.MailForDelivery;

@Repository
public interface MailForDeliveryDAO extends CrudRepository<MailForDelivery, Long>,PagingAndSortingRepository<MailForDelivery, Long> {

}
