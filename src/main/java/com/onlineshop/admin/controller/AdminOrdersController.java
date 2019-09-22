package com.onlineshop.admin.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshop.model.Order;
import com.onlineshop.model.OrderDetail;
import com.onlineshop.model.Product;
import com.onlineshop.service.OrderService;

@Controller
@RequestMapping("/admin")
public class AdminOrdersController {

	@Autowired
	private OrderService orderService;
	
	 @RequestMapping("/showOrders/{numPage}")
	 public String showOrders(Model model,
				@PathVariable(value = "numPage") Integer page) {
		 
		 Page<Order> pages=orderService.showAllOrders(page);
			List<Order> orders=new ArrayList<>();
					
					for (Order order : pages) {
						orders.add(order);
					}
		 
					Collections.sort(orders,new Comparator<Order>() {
				        public int compare(Order o1, Order o2) {
			                return o2.getId().compareTo(o1.getId());
			        }
			});
					
		 int currentPageNumber=pages.getNumber()+1;
			int beginIndex=Math.max(1, currentPageNumber-5);
			int endIndex=Math.min(beginIndex+10, pages.getTotalPages());
		 
			model.addAttribute("orders", orders);			
		 return"orderList";
	 }
	 
	 @RequestMapping("/order/{orderNum}/{orderid}")
	 public String orderDetail(Model model,
				@PathVariable(value = "orderNum") Long orderNum,
				@PathVariable(value = "orderid") Long orderid){
		 
		 
		 Order order = orderService.findOrder(orderid);
		 
		 List<OrderDetail> list = orderService.orderDetail(orderNum);
		 
		 model.addAttribute("listProducts", list);
		 model.addAttribute("order", order);
		 return "order";
	 }
	
}
