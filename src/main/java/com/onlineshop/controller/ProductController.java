package com.onlineshop.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshop.model.Category;
import com.onlineshop.model.Colour;
import com.onlineshop.model.MailForDelivery;
import com.onlineshop.model.Product;
import com.onlineshop.model_entity.CartInfo;
import com.onlineshop.service.CategoryService;
import com.onlineshop.service.ProductService;
import com.onlineshop.utils.Utils;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/allproducts/{numpage}")
	public String showAllProducts(Model model,
			@PathVariable(value = "numpage") Integer page,
			HttpServletRequest request) {
		Page<Product> pages=productService.showAllProducts(page);
		List<Product> products=new ArrayList<>();
				
				for (Product product : pages) {
					products.add(product);
				}
				
				int currentPageNumber=pages.getNumber()+1;
				int beginIndex=Math.max(1, currentPageNumber-5);
				int endIndex=Math.min(beginIndex+10, pages.getTotalPages());
				
			
				List<Category> categories = categoryService.allCategories();
				
				Collections.sort(categories);
				
				CartInfo myCart = Utils.getCartInSession(request);
				model.addAttribute("cartSize", myCart.getCartLines().size());
				
				
				MailForDelivery mail = new MailForDelivery();
				model.addAttribute("mail", mail);
				
				
				
				model.addAttribute("categories", categories);
				model.addAttribute("products",products);
			
				model.addAttribute("totalPages",pages.getTotalPages());
				model.addAttribute("currentPageNumber",currentPageNumber);
				model.addAttribute("beginIndex",beginIndex);
				model.addAttribute("endIndex",endIndex);
		
		model.addAttribute("title", "ВСЕ ТОВАРЫ");
		return"productsList";
	}
	
	@RequestMapping("/findByCategory/{categoryName}/{numpage}")
	public String findbyCategory(Model model,
			@PathVariable("numpage") Integer pageNum,
			@PathVariable("categoryName") String category,HttpServletRequest request) {
		Page<Product> page=productService.getAllProductByCategory(pageNum,
				category);
		
		
		List<Product> products=new ArrayList<>();
		
		for (Product product : page) {
			products.add(product);
		}
		
		
		int currentPageNumber=page.getNumber()+1;
		int beginIndex=Math.max(1, currentPageNumber-5);
		int endIndex=Math.min(beginIndex+10, page.getTotalPages());
		
		if (products.size()==0) {
			model.addAttribute("msg","Нет товаров данной категории");
		}
		
		List<Category> categories = categoryService.allCategories();
		
		Collections.sort(categories);
		
		MailForDelivery mail = new MailForDelivery();
		model.addAttribute("mail", mail);
		
		CartInfo myCart = Utils.getCartInSession(request);
		model.addAttribute("cartSize", myCart.getCartLines().size());
		
		model.addAttribute("categories", categories);
		model.addAttribute("products",products);
		model.addAttribute("category", category);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("currentPageNumber",currentPageNumber);
		model.addAttribute("beginIndex",beginIndex);
		model.addAttribute("endIndex",endIndex);
		model.addAttribute("title", "Найдено "+products.size()+" товаров по вашему запросу");
		return"productsList";
	}
	
	@RequestMapping("/findByPrice/{value}/{page}")
	public String findByPrice(Model model,
			@PathVariable("page") Integer page,
			@PathVariable("value") String value,HttpServletRequest request) {
		Page<Product> pages=productService.showAllProducts(page);
		List<Product> products=new ArrayList<>();
				
				for (Product product : pages) {
					products.add(product);
				}
				
				if(value.equals("up")) {
				Collections.sort(products,new Comparator<Product>() {
			        public int compare(Product o1, Product o2) {
		                return o1.getProductPrice().compareTo(o2.getProductPrice());
		        }
		});
				}else {
					Collections.sort(products,new Comparator<Product>() {
				        public int compare(Product o1, Product o2) {
			                return o2.getProductPrice().compareTo(o1.getProductPrice());
			        }
			});
				}
				int currentPageNumber=pages.getNumber()+1;
				int beginIndex=Math.max(1, currentPageNumber-5);
				int endIndex=Math.min(beginIndex+10, pages.getTotalPages());
				
			
				List<Category> categories = categoryService.allCategories();
				
				CartInfo myCart = Utils.getCartInSession(request);
				model.addAttribute("cartSize", myCart.getCartLines().size());
				
				MailForDelivery mail = new MailForDelivery();
				model.addAttribute("mail", mail);
				
				model.addAttribute("categories", categories);
				model.addAttribute("products",products);
			
				model.addAttribute("totalPages",pages.getTotalPages());
				model.addAttribute("currentPageNumber",currentPageNumber);
				model.addAttribute("beginIndex",beginIndex);
				model.addAttribute("endIndex",endIndex);
		
		model.addAttribute("title",
				"По цене от "+products.get(0).getProductPrice()+" до "+products.get(products.size()-1).getProductPrice());
		return"productsList";
	}
	
	@RequestMapping("/findByCategoryPrice/{value}/{categoryName}/{numpage}")
	public String findbyCategoryPrice(Model model,
			@PathVariable("numpage") Integer pageNum,
			@PathVariable("categoryName") String category,
			@PathVariable("value") String value,HttpServletRequest request) {
		Page<Product> page=productService.getAllProductByCategory(pageNum,
				category);
		
		
		List<Product> products=new ArrayList<>();
		
		for (Product product : page) {
			products.add(product);
		}
		
		if(value.equals("up")) {
		Collections.sort(products,new Comparator<Product>() {
	        public int compare(Product o1, Product o2) {
                return o1.getProductPrice().compareTo(o2.getProductPrice());
        }
});
		}else {
			Collections.sort(products,new Comparator<Product>() {
		        public int compare(Product o1, Product o2) {
	                return o2.getProductPrice().compareTo(o1.getProductPrice());
	        }
	});
		}
		int currentPageNumber=page.getNumber()+1;
		int beginIndex=Math.max(1, currentPageNumber-5);
		int endIndex=Math.min(beginIndex+10, page.getTotalPages());
		
		if (products.size()==0) {
			model.addAttribute("title","Нет товаров данной категории");
		}
		
		List<Category> categories = categoryService.allCategories();
		
		Collections.sort(categories);
		
		MailForDelivery mail = new MailForDelivery();
		model.addAttribute("mail", mail);
		
		CartInfo myCart = Utils.getCartInSession(request);
		model.addAttribute("cartSize", myCart.getCartLines().size());
		
		model.addAttribute("categories", categories);
		model.addAttribute("products",products);
		model.addAttribute("category", category);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("currentPageNumber",currentPageNumber);
		model.addAttribute("beginIndex",beginIndex);
		model.addAttribute("endIndex",endIndex);
		model.addAttribute("title", "Найдено "+products.size()+" товаров по вашему запросу "
				+ "по цене от "+products.get(0).getProductPrice()+" до "+products.get(products.size()-1).getProductPrice());
		return"productsList";
	}
	
	@RequestMapping("/showProductDetails/{productid}")
	public String showProductInDetails(Model model,
			@PathVariable("productid") Long productId,HttpServletRequest request) {
		
		Product product = productService.getProductById(productId);
		
List<Category> categories = categoryService.allCategories();
		
		Collections.sort(categories);
		List<Colour> colors = productService.getColoursOfProduct(productId);
		
		CartInfo myCart = Utils.getCartInSession(request);
		model.addAttribute("cartSize", myCart.getCartLines().size());
		
		MailForDelivery mail = new MailForDelivery();
		model.addAttribute("mail", mail);
		
		model.addAttribute("product", product);
		
		model.addAttribute("categories", categories);
		model.addAttribute("colors",colors);
		
		model.addAttribute("title", product.getProductCategory());
		
		
		return"ProductDetails";
	}
	
	
}
