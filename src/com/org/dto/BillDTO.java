package com.org.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class BillDTO {
	
	private int id;
	private String partyName;
	private int qty;
	private String item;
	private BigDecimal amount;
	private BigDecimal totalAmount;
	private Date billDate;
	private BigDecimal invoiceNo;
	private boolean isDeleted;
	
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public BigDecimal getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(BigDecimal invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	
	

}
