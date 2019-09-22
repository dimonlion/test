package com.onlineshop.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.onlineshop.model.Colour;
import com.onlineshop.model.Product;

public interface ProductService {

	void addProduct(Product product);
	Page<Product> showAllProducts(Integer pageNumber);
	
	void deleteProduct(Long idProduct);
	void updateProduct(Product product);
	Product getProductById(Long idProduct);
	public Page<Product> getAllProductByCategory(Integer pageNumber,String category);
	
	void addColourToProduct(Long idProduct,Colour colour);
	List<Colour> getColoursOfProduct(Long idProduct);
}
