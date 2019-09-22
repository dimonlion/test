package com.onlineshop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer implements Serializable{

	
	private static final long serialVersionUID = 3L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customerId;
	
	@NotEmpty
	@Size(min=6,max=30)
	private String customerName;
	
	
	@NotEmpty
	@Email
	private String customerEmailAddress;
	
	
	@NotEmpty
	private String custometPhoneNumber;
	
	@NotEmpty
	@Size(min=5,max=30)
	private String username;
	
	@NotEmpty
	//@Size(min=6,max=30)
	private String password;
	
	
	private boolean enabled;
	
	
	

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailAddress() {
		return customerEmailAddress;
	}

	public void setCustomerEmailAddress(String customerEmailAddress) {
		this.customerEmailAddress = customerEmailAddress;
	}

	public String getCustometPhoneNumber() {
		return custometPhoneNumber;
	}

	public void setCustometPhoneNumber(String custometPhoneNumber) {
		this.custometPhoneNumber = custometPhoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


		
}
