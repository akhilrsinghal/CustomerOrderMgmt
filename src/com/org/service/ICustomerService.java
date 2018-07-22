package com.org.service;

import java.util.List;
import java.util.Map;

import com.org.dto.BillDTO;
import com.org.dto.CustomerDTO;
import com.org.dto.OrderDTO;
import com.org.dto.ProductDTO;
import com.org.dto.TransactionDTO;
import com.org.dto.UserDTO;

public interface ICustomerService {
	@SuppressWarnings("rawtypes")
	public Map getCustomer(int custId);
	@SuppressWarnings("rawtypes")
	public Map saveCustomer(CustomerDTO customerDTO);
	public Map getProduct(int productId);
	public Map saveProduct(ProductDTO productDTO);
	public Map saveOrder(OrderDTO orderDTO);
	public Map getOrder();
	public Map getTransaction();
	public Map saveTransaction(TransactionDTO transactionDTO);
	public Map getTransactionByDate(String startDate, String endDate);
	public Map getCustomerRecord(int custId);
	public Map getGraphData();
	public Map getOrderByDate(String startDate, String endDate);
	public Map getTransactionByOrderId(int customerId, int orderPerCustId, int orderId);
	public Map getDashBoard(int year,String month);
	public Map getBillDetails(String startDate, String endDate);
	public Map userAuthenticate(UserDTO userDTO);
	public Map addBillDetails(List<BillDTO> billDTOs);
	public Map deleteBillByInvoice(Long invoiceId);
	//public Map getCustPendingAmnt();

}
