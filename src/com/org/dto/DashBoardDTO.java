package com.org.dto;

import java.util.List;

public class DashBoardDTO {
	private int custCount;
	private Long totalOrder;
	private Long clearedOrder;
	private Long pendingOrder;
	
	private List<YearSaleDTO> yearSaleList;
	private List<MonthSaleDTO> monthSaleList;
	private List<MonthSaleDTO> monthQtyist;
	private List<CustomerRecordDTO> custPendingAmnt;
	
	
	public List<CustomerRecordDTO> getCustPendingAmnt() {
		return custPendingAmnt;
	}
	public void setCustPendingAmnt(List<CustomerRecordDTO> custPendingAmnt) {
		this.custPendingAmnt = custPendingAmnt;
	}
	public List<MonthSaleDTO> getMonthQtyist() {
		return monthQtyist;
	}
	public void setMonthQtyist(List<MonthSaleDTO> monthQtyist) {
		this.monthQtyist = monthQtyist;
	}
	public List<MonthSaleDTO> getMonthSaleList() {
		return monthSaleList;
	}
	public void setMonthSaleList(List<MonthSaleDTO> monthSaleList) {
		this.monthSaleList = monthSaleList;
	}
	public List<YearSaleDTO> getYearSaleList() {
		return yearSaleList;
	}
	public void setYearSaleList(List<YearSaleDTO> yearSaleList) {
		this.yearSaleList = yearSaleList;
	}
	public int getCustCount() {
		return custCount;
	}
	public void setCustCount(int custCount) {
		this.custCount = custCount;
	}
	public Long getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(Long totalOrder) {
		this.totalOrder = totalOrder;
	}
	public Long getClearedOrder() {
		return clearedOrder;
	}
	public void setClearedOrder(Long clearedOrder) {
		this.clearedOrder = clearedOrder;
	}
	public Long getPendingOrder() {
		return pendingOrder;
	}
	public void setPendingOrder(Long pendingOrder) {
		this.pendingOrder = pendingOrder;
	}
	
	
	

}
