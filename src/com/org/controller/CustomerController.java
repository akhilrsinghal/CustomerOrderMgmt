package com.org.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.dto.BillDTO;
import com.org.dto.CustomerDTO;
import com.org.dto.OrderDTO;
import com.org.dto.ProductDTO;
import com.org.dto.TransactionDTO;
import com.org.dto.UserDTO;
import com.org.service.ICustomerService;

@Component
@Path("/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(@QueryParam("customerId")int custId) {
		Map customer = customerService.getCustomer(custId);
		return Response.ok(customer).build();
	}
	
	@SuppressWarnings("rawtypes")
	@POST
	@Path("/addCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveCustomer(CustomerDTO customerDTO){
		Map data = customerService.saveCustomer(customerDTO);
		return Response.ok(data).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getProduct")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@QueryParam("productId")int productId) {
		Map product = customerService.getProduct(productId);
		return Response.ok(product).build();
	}
	
	@SuppressWarnings("rawtypes")
	@POST
	@Path("/addProduct")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveProduct(ProductDTO productDTO){
		Map data = customerService.saveProduct(productDTO);
		return Response.ok(data).build();
	}
	
	@SuppressWarnings("rawtypes")
	@POST
	@Path("/addOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveOrder(OrderDTO orderDTO){
		Map data = customerService.saveOrder(orderDTO);
		return Response.ok(data).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getOrder")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrder() {
		Map order = customerService.getOrder();
		return Response.ok(order).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getTransaction")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransaction() {
		Map transaction = customerService.getTransaction();
		return Response.ok(transaction).build();
	}
	
	@SuppressWarnings("rawtypes")
	@POST
	@Path("/addTransaction")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveTransaction(TransactionDTO transactionDTO){
		Map data = customerService.saveTransaction(transactionDTO);
		return Response.ok(data).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getTransactionByDate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionByDate(@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate) {
		Map customer = customerService.getTransactionByDate(startDate, endDate);
		return Response.ok(customer).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getOrderByDate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrderByDate(@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate) {
		Map customer = customerService.getOrderByDate(startDate, endDate);
		return Response.ok(customer).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getCustomerRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerRecord(@QueryParam("customerId") int custId) {
		Map transaction = customerService.getCustomerRecord(custId);
		return Response.ok(transaction).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getGraphData")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGraphData() {
		Map transaction = customerService.getGraphData();
		return Response.ok(transaction).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getTransactionByOrderId")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionByOrderId(@QueryParam("customerId") int customerId,
			@QueryParam("orderPerCustId") int orderPerCustId,
			@QueryParam("orderId") int orderId) {
		Map transaction = customerService.getTransactionByOrderId(customerId, orderPerCustId, orderId);
		return Response.ok(transaction).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getDashBoard")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDashBoard(@QueryParam("year") int year,
			@QueryParam("month") String month) {
		Map transaction = customerService.getDashBoard(year,month);
		return Response.ok(transaction).build();
	}
	
	@SuppressWarnings("rawtypes")
	@GET
	@Path("/getBillDetails")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBillDetails(@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate) {
		Map transaction = customerService.getBillDetails(startDate, endDate);
		return Response.ok(transaction).build();
	}
	
	@SuppressWarnings("rawtypes")
	@DELETE
	@Path("/deleteBill")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBillByInvoice(@QueryParam("invoiceId") Long invoiceId) {
		Map transaction = customerService.deleteBillByInvoice(invoiceId);
		return Response.ok(transaction).build();
	}
	
	@SuppressWarnings("rawtypes")
	@POST
	@Path("/addBillDetails")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBillDetails(List<BillDTO> billDTOs){
		Map data = customerService.addBillDetails(billDTOs);
		return Response.ok(data).build();
	}
	
	
	/*@SuppressWarnings("rawtypes")
	@GET
	@Path("/getCustPendingAmnt")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustPendingAmnt() {
		Map transaction = customerService.getCustPendingAmnt();
		return Response.ok(transaction).build();
	}*/

	@SuppressWarnings("rawtypes")
	@POST
	@Path("/userAuthenticate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response userAuthenticate(UserDTO userDTO){
		Map data = customerService.userAuthenticate(userDTO);
		return Response.ok(data).build();
	}
}
