package com.onlineshop.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.model.Category;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Long> , PagingAndSortingRepository<Category, Long> {

}
