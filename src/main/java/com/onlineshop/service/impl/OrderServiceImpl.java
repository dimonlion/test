package com.onlineshop.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.OrderDAO;
import com.onlineshop.dao.OrderDetailDAO;
import com.onlineshop.model.Order;
import com.onlineshop.model.OrderDetail;
import com.onlineshop.model_entity.CartInfo;
import com.onlineshop.model_entity.CartLineInfo;
import com.onlineshop.model_entity.CustomerInfo;
import com.onlineshop.service.OrderService;
import com.onlineshop.service.ProductService;


@Service
public class OrderServiceImpl implements OrderService {

	// @Autowired
	// private SessionFactory sessionFactory;

	private static final int PAGE_ELEMENT_SIZE_CUSTOMER = 10;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderDetailDAO orderDetailDAO;

	@Autowired
	private OrderDAO orderDAO;

	// @Transactional
	// private int getMaxOrderNum() {
	// String sql = "Select max(o.orderNum) from " + Order.class.getName() + " o ";
	// Session session = sessionFactory.getCurrentSession();
	// Query query = session.createQuery(sql);
	// Integer value = (Integer) query.uniqueResult();
	// if (value == null) {
	// return 0;
	// }
	// return value;
	// }

	@Transactional
	public Long orderNum() {
		List<Order> list = (List<Order>) orderDAO.findAll();
		Long l = (long) list.size();
		return l;
	}

	@Override
	@Transactional
	public void saveOrder(CartInfo cartInfo) {

		// int orderNum = this.getMaxOrderNum() + 1;
		Order order = new Order();

		// order.setId(UUID.randomUUID().toString());
		order.setOrderNum(orderNum() + 1);
		order.setOrderDate(new Date());
		order.setAmount(cartInfo.getAmountTotal());

		CustomerInfo customerInfo = cartInfo.getCustomerInfo();
		order.setCustomerName(customerInfo.getName());
		order.setCustomerEmail(customerInfo.getEmail());
		order.setCustomerPhone(customerInfo.getPhone());
		order.setCustomerAddress(customerInfo.getAddress());

		orderDAO.save(order);

		List<CartLineInfo> lines = cartInfo.getCartLines();

		for (CartLineInfo line : lines) {
			OrderDetail detail = new OrderDetail();
			// detail.setId(UUID.randomUUID().toString());
			detail.setOrderNum(order.getOrderNum());
			detail.setAmount(line.getAmount());
			detail.setPrice(line.getProductInfo().getPrice());
			detail.setQuanity(line.getQuantity());

			Long code = line.getProductInfo().getCode();
			// Product product = this.productService.findProduct(code);
			detail.setProductCode(code);

			orderDetailDAO.save(detail);
		}

		// Set OrderNum for report.

		cartInfo.setOrderNum(orderNum());
	}

	@Override
	@Transactional
	public Page<Order> showAllOrders(Integer pageNum) {
		PageRequest pageRequest = new PageRequest(pageNum - 1, PAGE_ELEMENT_SIZE_CUSTOMER);
		return orderDAO.findAll(pageRequest);
	}

	@Override
	@Transactional
	public Order findOrder(Long idOrder) {

		return orderDAO.findOne(idOrder);
	}

	@Override
	@Transactional
	public List<OrderDetail> orderDetail(Long orderNum){
		return orderDetailDAO.showDetails(orderNum);
	}
	
}
