package com.org.dto;

import java.math.BigDecimal;


public class MonthSaleDTO {
	private String month;
	private BigDecimal amount;
	private BigDecimal qty;
	private BigDecimal monthProdAmount;
	private String productName;
	
	
	
	public BigDecimal getMonthProdAmount() {
		return monthProdAmount;
	}
	public void setMonthProdAmount(BigDecimal monthProdAmount) {
		this.monthProdAmount = monthProdAmount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	

}
