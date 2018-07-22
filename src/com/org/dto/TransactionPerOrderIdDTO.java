package com.org.dto;

public class TransactionPerOrderIdDTO {
	
		private int customerId;
		private int orderId;
		private int orderPerCustId;
		private Long remainAmount;
		private Long totalAmount;
		
		public Long getRemainAmount() {
			return remainAmount;
		}
		public void setRemainAmount(Long remainAmount) {
			this.remainAmount = remainAmount;
		}
		public Long getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(Long totalAmount) {
			this.totalAmount = totalAmount;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getOrderPerCustId() {
			return orderPerCustId;
		}
		public void setOrderPerCustId(int orderPerCustId) {
			this.orderPerCustId = orderPerCustId;
		}

		

}
