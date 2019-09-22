package com.onlineshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.model.Authorities;
import com.onlineshop.model.Customer;
import com.onlineshop.model.MailForDelivery;
import com.onlineshop.model.Users;
import com.onlineshop.service.AuthoritiesService;
import com.onlineshop.service.CustomerService;
import com.onlineshop.service.UsersService;


@Controller
public class RegisterController implements HandlerExceptionResolver{

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private AuthoritiesService authoritiesService;
	

	@RequestMapping("/register")
	public String registerCustomer(Model model){
			
		Customer customer=new Customer();

		MailForDelivery mail = new MailForDelivery();
		model.addAttribute("mail", mail);
		model.addAttribute("customer",customer);
		
		return "registerCustomer";
	}
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerCustomerPost(@Valid@ModelAttribute("customer")Customer customer,BindingResult result, @RequestParam(name="update",required=false) String update,@RequestParam(name="oldUserId",required=false)Long oldUserId ,Model model,HttpServletRequest request){
		
	
		if (result.hasErrors()) {
			return "registerCustomer";
		}
		
		List<Customer> customerList=customerService.getAllCustomers();
		
		for (Customer customer2 : customerList) {
			
			if (customer2.getCustomerEmailAddress().equals(customer.getCustomerEmailAddress())) {
				model.addAttribute("emailMsg","Почтовый ящик уже существует");
				return "registerCustomer";
			}
			
			if (customer2.getUsername().equals(customer.getUsername())) {
				model.addAttribute("usernameMsg","Логин уже занят");
				return "registerCustomer";
			}
		}
		
		//System.out.println("--------------------------update:"+update+" ------------"+oldUserId);
		
				
			
			customer.setEnabled(true);
			customerService.addCustomer(customer);
		    
			Users users=new Users();
			users.setCustomerId(customer.getCustomerId());
			users.setEnabled(true);
			users.setPassword(customer.getPassword());
			users.setUsername(customer.getUsername());
			
			usersService.addUsers(users);
			
			
			Authorities authorities=new Authorities();
			authorities.setUsername(customer.getUsername());
		
			if(authorities.getUsername().equals("admin")) {
			authorities.setAuthorityType("ROLE_ADMIN");
			}else {
				authorities.setAuthorityType("ROLE_USER");
			}
			
					
			
			authoritiesService.addAuthorities(authorities);

			customerService.addCustomer(customer);
			
			
			autoLogin(customer,request);
			
		
		return ("redirect:/");
	}



	private void autoLogin(Customer customer,HttpServletRequest request) {
	
		String username=customer.getUsername();
		String password=customer.getPassword();
		
		
		
		// generate session if one doesn't exist
        request.getSession();
        
        
        Authentication authentication=new UsernamePasswordAuthenticationToken(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
         
		
	}
	
	
	
	@RequestMapping("/customer/update")
	public String customerUpdate(){
		
		return "updateCustomer";
	}
	
	
	@RequestMapping(value="/customer/update",method=RequestMethod.POST)
	public String customerUpdatePost(@RequestParam("username")String username,@RequestParam("password")String password,Model model){
		
		Customer customer=customerService.findCustomerByusernameAndpassword(username, password);
		
		if (customer==null) {
			
			return "updateCustomer";
		}
		
		model.addAttribute("customer",customer);
		
		
		model.addAttribute("update","update");
		return "registerCustomer";
	}



	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
}
