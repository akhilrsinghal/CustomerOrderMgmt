package com.org.dto;

import java.util.Date;

public class OrderDTO {
	
	private int id;
	private int quantity;
	private Long netAmount;
	private Long amount;
	private int productId;
	private int customerId;
	private int orderPerCustomer;
	//private Date createdDate;
	private Date orderDate;
	
	
	
	public int getOrderPerCustomer() {
		return orderPerCustomer;
	}
	public void setOrderPerCustomer(int orderPerCustomer) {
		this.orderPerCustomer = orderPerCustomer;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Long netAmount) {
		this.netAmount = netAmount;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	/*public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}*/
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
	

}
