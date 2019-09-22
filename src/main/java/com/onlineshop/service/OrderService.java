package com.onlineshop.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.onlineshop.model.Order;
import com.onlineshop.model.OrderDetail;
import com.onlineshop.model_entity.CartInfo;



public interface OrderService {

	 public void saveOrder(CartInfo cartInfo);
	
	 public Page<Order> showAllOrders(Integer pageNum);
	 
	 public Order findOrder(Long idOrder);
	 
	 public List<OrderDetail> orderDetail(Long orderNum);
}
