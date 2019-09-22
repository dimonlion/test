package com.onlineshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onlineshop.model.Order;
import com.onlineshop.model.OrderDetail;
import com.onlineshop.model.Product;
import com.onlineshop.model_entity.CartInfo;
import com.onlineshop.model_entity.CustomerInfo;
import com.onlineshop.model_entity.ProductInfo;
import com.onlineshop.service.OrderService;
import com.onlineshop.service.ProductService;
import com.onlineshop.utils.Utils;



@Controller

public class CartController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	 @RequestMapping({ "/buyProduct" })
	    public String listProductHandler(HttpServletRequest request, Model model, //
	            @RequestParam(value = "code", defaultValue = "") Long code) {
	 
	        Product product = null;
	        if (code != null ) {
	            product = productService.getProductById(code);
	        }
	        if (product != null) {
	 
	            // Cart info stored in Session.
	            CartInfo cartInfo = Utils.getCartInSession(request);
	 
	            ProductInfo productInfo = new ProductInfo(product);
	 
	            cartInfo.addProduct(productInfo, 1);
	        }
	        CartInfo myCart = Utils.getCartInSession(request);
			model.addAttribute("cartSize", myCart.getCartLines().size());
	        
	        // Redirect to shoppingCart page.
	        return "redirect:/shoppingCart";
	    }
	
	 @RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.GET)
	    public String shoppingCartHandler(HttpServletRequest request, Model model) {
	        CartInfo myCart = Utils.getCartInSession(request);
	 
	       
			model.addAttribute("cartSize", myCart.getCartLines().size());
	        
	        model.addAttribute("cartForm", myCart);
	        return "shoppingCart";
	    }
	
	
	
	 @RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.POST)
	    public String shoppingCartUpdateQty(HttpServletRequest request, //
	            Model model, //
	            @ModelAttribute("cartForm") CartInfo cartForm) {
	 
	        CartInfo cartInfo = Utils.getCartInSession(request);
	        cartInfo.updateQuantity(cartForm);
	 
	        CartInfo myCart = Utils.getCartInSession(request);
			model.addAttribute("cartSize", myCart.getCartLines().size());
	        
	        // Redirect to shoppingCart page.
	        return "redirect:/shoppingCart";
	    }
	
	 @RequestMapping({ "/shoppingCartRemoveProduct" })
	    public String removeProductHandler(HttpServletRequest request, Model model, //
	            @RequestParam(value = "code", defaultValue = "") Long code) {
	        Product product = null;
	        if (code != null && code > 0) {
	            product = productService.getProductById(code);
	        }
	        if (product != null) {
	 
	            // Cart Info stored in Session.
	            CartInfo cartInfo = Utils.getCartInSession(request);
	 
	            ProductInfo productInfo = new ProductInfo(product);
	 
	            cartInfo.removeProduct(productInfo);
	 
	        }
	        // Redirect to shoppingCart page.
	        return "redirect:/shoppingCart";
	    }
	
	 @RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.GET)
	    public String shoppingCartCustomerForm(HttpServletRequest request, Model model) {
	 
	        CartInfo cartInfo = Utils.getCartInSession(request);
	      
	        // Cart is empty.
	        if (cartInfo.isEmpty()) {
	             
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        }
	 
	        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
	        if (customerInfo == null) {
	            customerInfo = new CustomerInfo();
	        }
	 
	        model.addAttribute("customerForm", customerInfo);
	 
	        return "shoppingCartCustomer";
	    }
	
	 @RequestMapping(value = { "/shoppingCartCustomer" }, method = RequestMethod.POST)
	    public String shoppingCartCustomerSave(HttpServletRequest request, //
	            Model model, //
	            @ModelAttribute("customerForm") CustomerInfo customerForm, //
	            BindingResult result, //
	            final RedirectAttributes redirectAttributes) {
	  
	        // If has Errors.
	        if (result.hasErrors()) {
	            customerForm.setValid(false);
	            // Forward to reenter customer info.
	            return "shoppingCartCustomer";
	        }
	 
	        System.out.println(customerForm.getName());
	        
	        customerForm.setValid(true);
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        cartInfo.setCustomerInfo(customerForm);
	 
	        // Redirect to Confirmation page.
	        return "redirect:/shoppingCartConfirmation";
	    }
	
	 @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.GET)
	    public String shoppingCartConfirmationReview(HttpServletRequest request, Model model) {
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        // Cart have no products.
	        if (cartInfo.isEmpty()) {
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        } else if (!cartInfo.isValidCustomer()) {
	            // Enter customer info.
	            return "redirect:/shoppingCartCustomer";
	        }
	 
	        return "shoppingCartConfirmation";
	    }
	
	 @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.POST)
	    // Avoid UnexpectedRollbackException (See more explanations)
	    @Transactional(propagation = Propagation.NEVER)
	    public String shoppingCartConfirmationSave(HttpServletRequest request, Model model) {
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        // Cart have no products.
	        if (cartInfo.isEmpty()) {
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        } else if (!cartInfo.isValidCustomer()) {
	            // Enter customer info.
	            return "redirect:/shoppingCartCustomer";
	        }
	        try {
	        	orderService.saveOrder(cartInfo);
	        } catch (Exception e) {
	            // Need: Propagation.NEVER?
	            return "shoppingCartConfirmation";
	        }
	        // Remove Cart In Session.
	        Utils.removeCartInSession(request);
	         
	        // Store Last ordered cart to Session.
	        Utils.storeLastOrderedCartInSession(request, cartInfo);
	 
	        // Redirect to successful page.
	        return "redirect:/shoppingCartFinalize";
	    }
	 
	 @RequestMapping(value = { "/shoppingCartFinalize" }, method = RequestMethod.GET)
	    public String shoppingCartFinalize(HttpServletRequest request, Model model) {
	 
	        CartInfo lastOrderedCart = Utils.getLastOrderedCartInSession(request);
	 
	        if (lastOrderedCart == null) {
	            return "redirect:/shoppingCart";
	        }
	 
	        return "shoppingCartFinalize";
	    }
	 
	
	
	
}
