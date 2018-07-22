package com.org.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TRANSACTION",schema="customer")
public class TransactionEntity {
	
	private int id;
	private Customer customer;
	private Order order;
	private Long totalAmount;
	private Long remainingAmount;
	private Long submittedAmount;
	private Date createdDate;
	private int orderPerCustomer;
	
	@Column(name = "ORDER_PER_CUSTOMER")
	public int getOrderPerCustomer() {
		return orderPerCustomer;
	}
	public void setOrderPerCustomer(int orderPerCustomer) {
		this.orderPerCustomer = orderPerCustomer;
	}
	@Id
	@GeneratedValue
	@Column(name = "TRANSACTION_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "TOTAL_AMOUNT")
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Column(name = "SUBMITTED_AMOUNT")
	public Long getSubmittedAmount() {
		return submittedAmount;
	}
	public void setSubmittedAmount(Long submittedAmount) {
		this.submittedAmount = submittedAmount;
	}
	
	@Column(name = "REMAINING_AMOUNT")
	public Long getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(Long remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@ManyToOne/*(fetch = FetchType.EAGER)*/
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	

}
