package com.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.CategoryDAO;
import com.onlineshop.model.Category;
import com.onlineshop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	private static final int PAGE_ELEMENT_SIZE_CUSTOMER=12;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	@Transactional
	public void addCategory(Category category) {
		categoryDAO.save(category);
		
	}

	@Override
	@Transactional
	public Page<Category> showAllCategories(Integer pageNumber) {
		PageRequest request = new PageRequest(pageNumber-1, PAGE_ELEMENT_SIZE_CUSTOMER);
		return categoryDAO.findAll(request);
	}

	@Override
	@Transactional
	public List<Category> allCategories() {
		// TODO Auto-generated method stub
		return (List<Category>) categoryDAO.findAll();
	}

}
