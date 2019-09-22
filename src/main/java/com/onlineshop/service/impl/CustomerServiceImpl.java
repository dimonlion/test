package com.onlineshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.CustomerDao;
import com.onlineshop.model.Customer;
import com.onlineshop.service.CustomerService;





@Service

public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public void addCustomer(Customer customer) {
		if(customer.getPassword()!=null){
			String pass=customer.getPassword();
			customer.setPassword(passwordEncoder.encode(pass));
		}
		customerDao.save(customer);
	}

	@Transactional(readOnly = true)
	@Override
	public Customer findCustomerByUsername(String username) {
		
		return customerDao.findUserByusername(username);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Customer> getAllCustomers() {
		
		return (List<Customer>) customerDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Customer getCustomerBycustomerId(long customerId) {
		
		return customerDao.findOne(customerId);
	}

	@Transactional(readOnly = true)
	@Override
	public Customer findCustomerByusernameAndpassword(String username, String password) {
		
		return customerDao.findCustomerByUsernameAndPassword(username, password);
	}

	
	
	
	
}
