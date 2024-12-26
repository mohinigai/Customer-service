package com.task.service;

import java.util.List;

import com.task.model.Customer;

public interface CustomerServiceI {
	
	Customer createCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	Customer getSingleCustomer(Long custId);
	
	Customer updateCustomer(Customer customer ,Long custId);
	
	 void deleteCustomer(Long custId);
	
	

}
