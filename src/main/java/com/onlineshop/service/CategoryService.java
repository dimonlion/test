package com.onlineshop.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.onlineshop.model.Category;

public interface CategoryService {

	void addCategory(Category category);
	Page<Category> showAllCategories(Integer pageNumber);
	List<Category> allCategories();
}
