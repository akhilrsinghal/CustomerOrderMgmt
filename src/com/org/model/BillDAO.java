package com.org.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="BILL",schema="customer")
public class BillDAO {

	private int id;
	private String partyName;
	private int qty;
	private String item;
	private BigDecimal amount;
	private BigDecimal totalAmount;
	private Date billDate;
	private BigDecimal invoiceNo;
	private int deletedFlag;
	
	@Id
	@GeneratedValue
	@Column(name = "BILL_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "PARTY_NAME")
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	
	@Column(name = "QUANTITY")
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@Column(name = "PRODUCT_NAME")
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	@Column(name = "AMOUNT")
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Column(name = "TOTAL_AMOUNT")
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	
	@Column(name = "INVOICE_NO")
	public BigDecimal getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(BigDecimal invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	@Column(name = "DELETED_FLAG")
	public int getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(int deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	
	//@Type(type="org.hibernate.type.NumericBooleanType")
	
}
