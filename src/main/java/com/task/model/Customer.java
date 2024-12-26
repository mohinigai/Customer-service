package com.task.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.task.Dto.Cart;
import com.task.Dto.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CUSTOMER_DTL")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	private Long customerId;
	
	@Column(name = "CART_ID")
	private Long cartId;
	
	@Column(name="CUSTOMER_NAME")
	private String name;
	
	@Column(name="EMAIL_ID")
	private String email;
	
	@Column(name="CUSTOMER_ADDRESS")
	private String address;
	
	@Column(name="MOBILE_NUMBER")
	private Long moblie;
	
	@Column(name="IS_ACTIVE")
	private String isactive;

	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;

	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
	
    @Transient
    private List<Order> orderList;
    //private OrderDto orderList;
    
    @Transient
    private List<Cart> cartList;
    
    
    
}