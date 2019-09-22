package com.onlineshop.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.model.Order;



@Repository
public interface OrderDAO extends CrudRepository<Order, Long> , PagingAndSortingRepository<Order, Long>{

}
