package com.task.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.task.Dto.Cart;
import com.task.Dto.Order;
import com.task.model.Customer;
import com.task.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public Customer createCustomer(Customer customer) {
		Customer savecust = customerRepo.save(customer);
		return savecust;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list = customerRepo.findAll().stream().map(a -> a).collect(Collectors.toList());
		return list;
	}

	@Override
	public Customer getSingleCustomer(Long custId) {
		Customer customer = customerRepo.findById(custId)
				.orElseThrow(() -> new RuntimeException("Customer id not found" + custId));

		String url = "http://localhost:9095/api/orders/customer/" + customer.getCustomerId();
		Order[] order = restTemplate.getForObject(url, Order[].class);
		List<Order> orderList = Arrays.asList(order);
		customer.setOrderList(orderList);

		String url1 = "http://localhost:9091/api/cart/customer/" + customer.getCustomerId();
		List<Cart> cartList = new ArrayList<>();
		ArrayList forObject1 = restTemplate.getForObject(url1, ArrayList.class);

		customer.setCartList(forObject1);

		return customer;

	}

	@Override
	public Customer updateCustomer(Customer customer, Long custId) {
		Customer byId = customerRepo.findById(custId)
				.orElseThrow(() -> new RuntimeException("Customer id not found" + custId));
		byId.setAddress(customer.getAddress());
		byId.setEmail(customer.getEmail());
		byId.setName(customer.getName());
		byId.setIsactive(customer.getIsactive());
		Customer updatedCustomer = customerRepo.save(byId);
		return updatedCustomer;
	}

	@Override
	public void deleteCustomer(Long custId) {
		Customer deletbyId = customerRepo.findById(custId)
				.orElseThrow(() -> new RuntimeException("Customer id not found" + custId));
		customerRepo.delete(deletbyId);
	}

}
