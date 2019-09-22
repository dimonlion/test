package com.onlineshop.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineshop.model.Category;
import com.onlineshop.model.MailForDelivery;
import com.onlineshop.model.Product;
import com.onlineshop.model_entity.CartInfo;
import com.onlineshop.service.CategoryService;
import com.onlineshop.service.MailForDeliveryService;
import com.onlineshop.service.ProductService;
import com.onlineshop.utils.Utils;

@Controller
public class HomeController {

	@Autowired
	private MailForDeliveryService mailForDeliveryService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/")
	public String home(Model model,HttpServletRequest request) {
		List<Category> categories = categoryService.allCategories();
		
		
		Collections.sort(categories);
		
		CartInfo myCart = Utils.getCartInSession(request);
		model.addAttribute("cartSize", myCart.getCartLines().size());
		
		MailForDelivery mail = new MailForDelivery();
		model.addAttribute("mail", mail);
		model.addAttribute("categories", categories);
		model.addAttribute("title", "ОНЛАЙН МАГАЗИН ОДЕЖДЫ TARAN");
		return"home_page";
	}
	
	
	
	@RequestMapping("/login")
	   public String login(
	           @RequestParam(value="error", required = false)
	           String error,
	           @RequestParam(value="logout", required = false)
	           String logout,
	           Model model){

	       if(error != null){
	           model.addAttribute("error", "Неверный логин и(или) пароль");
	       }

	       if (logout !=null){
	           model.addAttribute("msg", "Регистрация прошла успешно");
	       }

	       List<Category> categories = categoryService.allCategories();
			
			Collections.sort(categories);
			
			
			model.addAttribute("categories", categories);
	       
	       return "login";
	   }
	  @RequestMapping(value="/logout", method = RequestMethod.GET)
		public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null){    
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			
			cancelCookie(request, response);
			return "redirect:/login?logout";//можно redirect любую страницу,но на практике лучше всего вернуть страницу для логирования.
		}
	  
	  void cancelCookie(HttpServletRequest request, HttpServletResponse response)
	   {
	     String cookieName = "remember-me";
	     Cookie cookie = new Cookie(cookieName, null);
	     cookie.setMaxAge(0);
	     cookie.setPath(StringUtils.hasLength(request.getContextPath()) ? request.getContextPath() : "/");
	     response.addCookie(cookie);
	   }
	  
}
