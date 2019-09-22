package com.onlineshop.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlineshop.model.Product;

@Repository
public interface ProductDAO extends CrudRepository<Product, Long> , PagingAndSortingRepository<Product, Long>{
	
	Page<Product> findAllProductByproductCategory(String category,Pageable pageable);
}
