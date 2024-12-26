package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Customer;
import com.task.service.CustomerServiceI;
import com.task.util.Apiresponse;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerServiceI customerServiceI;

	@PostMapping("/customer")
	ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer customer2 = customerServiceI.createCustomer(customer);
		return new ResponseEntity<Customer>(customer2, HttpStatus.CREATED);

	}
	@GetMapping("/customer")
	ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> allCustomer = customerServiceI.getAllCustomer();
		return new ResponseEntity<List<Customer>>(allCustomer, HttpStatus.OK);

	}

	@PutMapping("/customer/{id}")
	ResponseEntity<Customer> updateCutomer(@RequestBody Customer customer, @PathVariable("id") Long custId) {
		Customer updateCustomer = customerServiceI.updateCustomer(customer, custId);
		return new ResponseEntity<Customer>(updateCustomer, HttpStatus.CREATED);

	}

	@GetMapping("/customer/{id}")
	ResponseEntity<Customer> getSingleCustomer(@PathVariable("id") Long custId) {
		Customer singleCustomer = customerServiceI.getSingleCustomer(custId);
		return new ResponseEntity<Customer>(singleCustomer, HttpStatus.OK);

	}
	
	@DeleteMapping("/customer/{id}")
	ResponseEntity<Apiresponse> deleteCustomer(@PathVariable("id") Long custId) {
		customerServiceI.deleteCustomer(custId);
		return new ResponseEntity<Apiresponse>(new Apiresponse ("Customer deleted successfully",true),HttpStatus.OK);
	}
}