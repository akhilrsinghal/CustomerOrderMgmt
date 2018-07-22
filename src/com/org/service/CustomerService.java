package com.org.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.dao.CustomerDAO;
import com.org.dto.BillDTO;
import com.org.dto.CustomerDTO;
import com.org.dto.OrderDTO;
import com.org.dto.ProductDTO;
import com.org.dto.TransactionDTO;
import com.org.dto.UserDTO;
import com.org.model.Customer;

@Transactional
@Service
public class CustomerService implements ICustomerService  {

	@Autowired
	CustomerDAO customerDAO;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getCustomer(int custId) {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.getCustomers(custId);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public Map saveCustomer(CustomerDTO customerDTO){
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		Customer customer = new Customer();
		try{
			hmOutput = customerDAO.saveCustomer(customerDTO);
			hmOutput.get("customer");
			
		}
		catch(Exception e ){
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getProduct(int productId) {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.getProduct(productId);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map saveProduct(ProductDTO productDTO){
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try{
			hmOutput = customerDAO.saveProduct(productDTO);
			hmOutput.get("product");
		}
		catch(Exception e ){
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map saveOrder(OrderDTO orderDTO){
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try{
			
			Long amount = orderDTO.getAmount();
			int qty = orderDTO.getQuantity();
			Long totalAmnt = (long) (amount * qty);
			orderDTO.setNetAmount(totalAmnt);
			
			hmOutput = customerDAO.saveOrder(orderDTO);
			hmOutput.get("order");
		}
		catch(Exception e ){
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getOrder() {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.getOrder();
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getTransaction() {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.getTransaction();
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map saveTransaction(TransactionDTO transactionDTO){
		Map<String, Object> hmOutput = new HashMap<>();
		//hmOutput.put("Success", true);
		//hmOutput.put("Success", "Successfully done!");
		
		try{
			hmOutput= customerDAO.saveTransaction(transactionDTO);
			hmOutput.get("txn");
		}
		catch(Exception e ){
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getTransactionByDate(String startDate, String endDate){
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			 SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy");
			 SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
			 
			 Date date1 = inSDF.parse(startDate);
			 Date date2 = inSDF.parse(endDate);
	         String fromDate = outSDF.format(date1);
	         String toDate = outSDF.format(date2);
			
			hmOutput = customerDAO.getTransactionByDate(fromDate, toDate);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getOrderByDate(String startDate, String endDate){
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			 SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy");
			 SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
			 
			 Date date1 = inSDF.parse(startDate);
			 Date date2 = inSDF.parse(endDate);
	         String fromDate = outSDF.format(date1);
	         String toDate = outSDF.format(date2);
			
			hmOutput = customerDAO.getOrderByDate(fromDate, toDate);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getCustomerRecord(int custId) {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.getCustomerRecord(custId);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getGraphData() {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.getGraphData();
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getTransactionByOrderId(int customerId, int orderPerCustId,int orderId) {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.getTransactionByOrderId(customerId, orderPerCustId, orderId);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getDashBoard(int year,String month) {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.getDashBoard(year,month);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getBillDetails(String startDate, String endDate) {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy");
			 SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
			 String fromDate = "";
			 String toDate = "";
			 if(!startDate.isEmpty() && !endDate.isEmpty() ){
				 Date date1 = inSDF.parse(startDate);
				 Date date2 = inSDF.parse(endDate);
		          fromDate = outSDF.format(date1);
		          toDate = outSDF.format(date2);
			 }
			hmOutput = customerDAO.getBillDetails(fromDate,toDate);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map deleteBillByInvoice(Long invoiceId) {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.deleteBillByInvoice(invoiceId);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map addBillDetails(List<BillDTO> billDTOs) {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.addBillDetails(billDTOs);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map userAuthenticate(UserDTO userDTO){
		Map<String, Object> hmOutput = new HashMap<>();
		//hmOutput.put("Success", true);
		//hmOutput.put("Success", "Successfully done!");
		
		try{
			hmOutput= customerDAO.userAuthenticate(userDTO);
			hmOutput.get("txn");
		}
		catch(Exception e ){
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}
	
	/*@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getCustPendingAmnt() {
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			hmOutput = customerDAO.getCustPendingAmnt();
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Error", e.getMessage());
		}
		return hmOutput;
	}*/
}
