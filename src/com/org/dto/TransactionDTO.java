package com.org.dto;

import java.util.Date;

public class TransactionDTO {
	
	private int id;
	private int customerId;
	private int orderId;
	private int orderPerCustomer;
	private Long totalAmount;
	private Long remainingAmount;
	private Long depositAmount;
	private Date createdDate;
	
	
	
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
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Long getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(Long remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	public Long getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(Long depositAmount) {
		this.depositAmount = depositAmount;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	

}
