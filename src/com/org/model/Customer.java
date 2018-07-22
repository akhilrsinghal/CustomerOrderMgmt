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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="CUSTOMER",schema="customer")
public class Customer {
	
	private int id;
	private String custName;
	private String custAddress;
	private String emailId;
	private String phNumber;
	private Date createdDate;
	private String gstNumber;
	private Set<Order> order = new HashSet<Order>(0);
	private Set<TransactionEntity> transaction = new HashSet<TransactionEntity>();
	
	public Customer(){
		
	}
	
	public Customer(int id, String custName, String custAddress, String emailId, String phNumber, Date createdDate,
			Set<Order> order, Set<TransactionEntity> transaction) {
		super();
		this.id = id;
		this.custName = custName;
		this.custAddress = custAddress;
		this.emailId = emailId;
		this.phNumber = phNumber;
		this.createdDate = createdDate;
		this.order = order;
		this.transaction = transaction;
	}
	@Id
	@GeneratedValue
	@Column(name = "CUSTOMER_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "CUSTOMER_NAME")
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	@Column(name = "CUSTOMER_ADDRESS")
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	@Column(name = "CUSTOMER_EMAIL")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "CUSTOMER_PHONE")
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	public Set<TransactionEntity> getTransaction() {
		return transaction;
	}
	public void setTransaction(Set<TransactionEntity> transaction) {
		this.transaction = transaction;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	@Column(name = "GST_NUMBER")
	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

}
