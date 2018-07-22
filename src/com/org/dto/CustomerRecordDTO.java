package com.org.dto;

import java.math.BigDecimal;

//import com.fasterxml.jackson.annotation.JsonIgnore;



public class CustomerRecordDTO {
	private Long totalAmount;
	private Long depositedAmount;
	private Long remainingAmount;
	private int custId;
	private String custName;
	private BigDecimal totalMonthAmount;
	private Integer month;
	
	
	//@JsonIgnore
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	//@JsonIgnore
	public Long getDepositedAmount() {
		return depositedAmount;
	}
	public void setDepositedAmount(Long depositedAmount) {
		this.depositedAmount = depositedAmount;
	}
	//@JsonIgnore
	public Long getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(Long remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	//@JsonIgnore
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	//@JsonIgnore
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	//@JsonIgnore
	public BigDecimal getTotalMonthAmount() {
		return totalMonthAmount;
	}
	public void setTotalMonthAmount(BigDecimal totalMonthAmount) {
		this.totalMonthAmount = totalMonthAmount;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	

}
