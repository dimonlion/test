package com.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.ColourDAO;
import com.onlineshop.dao.ProductDAO;
import com.onlineshop.model.Colour;
import com.onlineshop.model.Product;
import com.onlineshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private static final int PAGE_ELEMENT_SIZE_CUSTOMER=3;
	
	@Autowired
	private ColourDAO colourDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Transactional
	@Override
	public void addProduct(Product product) {
		productDAO.save(product);
		
	}

	@Transactional
	@Override
	public Page<Product> showAllProducts(Integer pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber-1, PAGE_ELEMENT_SIZE_CUSTOMER);
		return productDAO.findAll(pageRequest);
	}

	@Override
	@Transactional
	public void deleteProduct(Long idProduct) {
		productDAO.delete(idProduct);
		
	}

	@Override
	@Transactional
	public void updateProduct(Product product) {
		productDAO.save(product);
		
	}

	@Override
	@Transactional
	public Product getProductById(Long idProduct) {
		
		return productDAO.findOne(idProduct);
	}

	@Transactional
	@Override
	public Page<Product> getAllProductByCategory(Integer pageNumber,String category) {
		
		Pageable pageable=createPageRequest(pageNumber-1,PAGE_ELEMENT_SIZE_CUSTOMER);
		
		
		
		return productDAO.findAllProductByproductCategory(category,pageable);
	}
	
	
	private Pageable createPageRequest(int pageNumber,int size) {
	    return new PageRequest(pageNumber,size);
	}


	@Override
	@Transactional
	public void addColourToProduct(Long idProduct, Colour colour) {
		
	colourDAO.save(colour);
	Product existProduct = getProductById(idProduct);
	existProduct.getProductColours().add(colour);
		productDAO.save(existProduct);
	}

	@Override
	@Transactional
	public List<Colour> getColoursOfProduct(Long idProduct) {
		Product existProduct = getProductById(idProduct);
		List<Colour> colours = existProduct.getProductColours();
		return colours;
	}
	
}
