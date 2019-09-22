package com.onlineshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlineshop.model.OrderDetail;




@Repository
public interface OrderDetailDAO extends CrudRepository<OrderDetail, Long> , PagingAndSortingRepository<OrderDetail, Long>{

	@Query("SELECT t FROM OrderDetail t WHERE t.orderNum =:orderNum ")
	public List<OrderDetail> showDetails(@Param("orderNum") Long orderNum);
	
}
