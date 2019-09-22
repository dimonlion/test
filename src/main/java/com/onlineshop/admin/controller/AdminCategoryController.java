package com.onlineshop.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.onlineshop.model.Category;
import com.onlineshop.model.Product;
import com.onlineshop.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/allcategories/{pageNumber}")
	public String categories(Model model,@PathVariable("pageNumber")int page) {
		Page<Category> pages=categoryService.showAllCategories(page);
List<Category> categories=new ArrayList<>();
		
		for (Category category : pages) {
			categories.add(category);
		}
		int currentPageNumber=pages.getNumber()+1;
		int beginIndex=Math.max(1, currentPageNumber-5);
		int endIndex=Math.min(beginIndex+10, pages.getTotalPages());
		
	
		
		model.addAttribute("categories",categories);
	
		model.addAttribute("totalPages",pages.getTotalPages());
		model.addAttribute("currentPageNumber",currentPageNumber);
		model.addAttribute("beginIndex",beginIndex);
		model.addAttribute("endIndex",endIndex);
		return"categoryManagement";
	}
	
	@RequestMapping("/formcreatecategory")
	public String formCategory(Model model) {
		Category category = new Category();
		
		model.addAttribute("category", category);
		return"formCategory";
	}
	
	@RequestMapping(value = "/addCategory",method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category,
			 HttpServletRequest httpServletRequest,
			 @RequestParam CommonsMultipartFile[] fileUpload) throws UnsupportedEncodingException {
		for(CommonsMultipartFile afile : fileUpload) {
			
			
			category.setCategoryPhoto(afile.getBytes());
			byte[] encodeBase64 = Base64.encodeBase64(category.getCategoryPhoto());
			String base64Encoded;
			
				base64Encoded = new String(encodeBase64, "UTF-8");
			
			category.setCategoryPhotoString(base64Encoded);
			}
		categoryService.addCategory(category);
		return("redirect:/admin/allcategories/1");
	}
	
	
}
