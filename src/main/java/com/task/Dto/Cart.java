package com.task.Dto;

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
public class Cart {
	
	private Long cartId;
    
	private Long customerId;
    
	private Long pid;
    
	private Integer quantity;
    
	private String isAdded;
	
	private List<Product> productList;
	

}
