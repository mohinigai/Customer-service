package com.task.Dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

	private Long ordid;
	
	private Long pid;

	private Long customerId;

	private Long cartId;

	private Double totalAmount;

	private Integer quntity;

	private String address;

	private String paymentMode;

	private String isDeliver;

	private LocalDate createDate;

	private LocalDate updateDate;
    
	private List<Product> productList;
	
}
