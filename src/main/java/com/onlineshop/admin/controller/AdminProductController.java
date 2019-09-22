package com.onlineshop.admin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.onlineshop.model.Category;
import com.onlineshop.model.Colour;
import com.onlineshop.model.Product;
import com.onlineshop.service.CategoryService;
import com.onlineshop.service.ProductService;



@Controller()
@RequestMapping("/admin")
public class AdminProductController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping
	public String adminPage(){
		
		return "admin";
	}
	
	@RequestMapping("/formaddcolour/{idproduct}")
	public String formAddColour(Model model,
			@PathVariable("idproduct") Long productId) {
		Colour colour = new Colour();
		
		model.addAttribute("productId", productId);
		model.addAttribute("colour", colour);
		return"FormAddColour";
	}
	
	@RequestMapping(value = "/addcolour/{productId}",method = RequestMethod.POST)
	public String addColour(Model model,
			@ModelAttribute("colour") Colour colour,
			@PathVariable("productId") Long productId,
			 @RequestParam CommonsMultipartFile[] fileUpload) {
for(CommonsMultipartFile afile : fileUpload) {
			
			
	colour.setColourMainPhoto(afile.getBytes());
			byte[] encodeBase64 = Base64.encodeBase64(colour.getColourMainPhoto());
			String base64Encoded = null;
			
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					
					e.printStackTrace();
				}
			
				colour.setColourMainPhotoString(base64Encoded);
			}
		productService.addColourToProduct(productId, colour);
		
		return("redirect:/admin/allproducts/1");
	}
	
	@RequestMapping("/allproducts/{pageNumber}")
	public String products(Model model,@PathVariable("pageNumber")int page) {
		Page<Product> pages=productService.showAllProducts(page);
List<Product> products=new ArrayList<>();
		
		for (Product product : pages) {
			products.add(product);
		}
		int currentPageNumber=pages.getNumber()+1;
		int beginIndex=Math.max(1, currentPageNumber-5);
		int endIndex=Math.min(beginIndex+10, pages.getTotalPages());
		
	
		
		model.addAttribute("products",products);
	
		model.addAttribute("totalPages",pages.getTotalPages());
		model.addAttribute("currentPageNumber",currentPageNumber);
		model.addAttribute("beginIndex",beginIndex);
		model.addAttribute("endIndex",endIndex);
		return"productsmanagment";
	}
	
	@RequestMapping("/formcreateproduct")
	public String formProduct(Model model) {
		Product product = new Product();
		
		List <Category> categories = categoryService.allCategories();
		List<String> categoryName = new ArrayList<>();
		for(Category res : categories) {
			categoryName.add(res.getCategoryName());
		}
		
		model.addAttribute("categories2", categoryName);
		model.addAttribute("product", product);
		return"formproduct";
	}
	
	@RequestMapping(value = "/addProduct",method = RequestMethod.POST)
	public String add(@ModelAttribute("product") Product prod,
			 HttpServletRequest httpServletRequest,
			 @RequestParam CommonsMultipartFile[] fileUpload) throws UnsupportedEncodingException {
		for(CommonsMultipartFile afile : fileUpload) {
			
			
			prod.setProductPhoto(afile.getBytes());
			byte[] encodeBase64 = Base64.encodeBase64(prod.getProductPhoto());
			String base64Encoded;
			
				base64Encoded = new String(encodeBase64, "UTF-8");
			
			prod.setProductPhotoString(base64Encoded);
			}
		productService.addProduct(prod);
		return("redirect:/admin/allproducts/1");
	}
	
	@RequestMapping("/product/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")long productId) throws Exception{		
			
		productService.deleteProduct(productId);
		
		return "redirect:/admin/allproducts/1";	
	}
	
	@RequestMapping("/showProductDetail/{productId}")
	public String showProductDetailAdmin(Model model,
			@PathVariable("productId") Long productId) {
		Product product = productService.getProductById(productId);
		List<Colour> coloursList =productService.getColoursOfProduct(productId);
		
		model.addAttribute("product", product);
		model.addAttribute("coloursList", coloursList);
		return"ProductDetailAdmin";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
