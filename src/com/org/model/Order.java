package com.org.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "ORDER" , schema = "customer")
public class Order {
	private int id;
	private int quantity;
	private Long netAmount;
	private Long amount;
	private Product product;
	private Customer customer;
	private int orderPerCustomer;
	private Set<TransactionEntity> transaction = new HashSet<TransactionEntity>();
	private Date createdDate;
	
	
	public Order(){
		
	}
	
	@Column(name = "ORDER_PER_CUSTOMER")
	public int getOrderPerCustomer() {
		return orderPerCustomer;
	}

	public void setOrderPerCustomer(int orderPerCustomer) {
		this.orderPerCustomer = orderPerCustomer;
	}

	public Order(int id, int quantity, Long netAmount, Long amount, Product product, Customer customer,
			Date createdDate) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.netAmount = netAmount;
		this.amount = amount;
		this.product = product;
		this.customer = customer;
		this.createdDate = createdDate;
	}
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "Quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "AMOUNT")
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	@Column(name = "NET_AMOUNT")
	public Long getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Long netAmount) {
		this.netAmount = netAmount;
	}
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 23)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	public Set<TransactionEntity> getTransaction() {
		return transaction;
	}
	public void setTransaction(Set<TransactionEntity> transaction) {
		this.transaction = transaction;
	}
	
	
	

}
