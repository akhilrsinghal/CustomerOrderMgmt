package com.org.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.dto.BillDTO;
import com.org.dto.CustomerDTO;
import com.org.dto.CustomerRecordDTO;
import com.org.dto.DashBoardDTO;
import com.org.dto.MonthSaleDTO;
import com.org.dto.OrderDTO;
import com.org.dto.ProductDTO;
import com.org.dto.TransactionDTO;
import com.org.dto.TransactionPerOrderIdDTO;
import com.org.dto.UserDTO;
import com.org.dto.YearSaleDTO;
import com.org.model.BillDAO;
import com.org.model.Customer;
import com.org.model.Order;
import com.org.model.Product;
import com.org.model.TransactionEntity;
import com.org.model.User;
@Repository
public class CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public Map getCustomers() throws Exception {
		Session session = null;
		Transaction transaction = null;
		List<Customer> cust = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			session = getSession();
			Criteria criteria = session.createCriteria(Customer.class);
			cust = criteria.list();
			hmOutput.put("customer", cust);
			System.out.println(cust);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}*/
	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public Map getCustomers(int custId) throws Exception {
		Session session = null;
		Transaction transaction = null;
		List<Customer> cust = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			session = getSession();
			Criteria criteria = session.createCriteria(Customer.class);
			
			if(custId == 0){
				cust = criteria.list();
				hmOutput.put("customer", cust);
				System.out.println(cust);
			}
			else{
				criteria.add(Restrictions.eq("id", custId));
				cust = criteria.list();
				hmOutput.put("customer", cust);
			}

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map saveCustomer(CustomerDTO customerDTO) throws IllegalStateException {
		Map<String, Object> hmOutput = new HashMap<>();
		Session session = null;
		//Transaction transaction = null;
		hmOutput.put("Success", true);
		//hmOutput.put("customer", "Customer Added Successfully.");
		try {
			Customer customer = new Customer();
			List<Customer> customerList = null;
			session = getSession();
			Criteria criteria = session.createCriteria(Customer.class);
			criteria.add(Restrictions.eq("custName", customerDTO.getCustName()));
			customerList = criteria.list();
			if(customerList.size()>=1){
				hmOutput.put("customer", "Customer already exist.");
			}
			else{
				Date currentDate = new Date();
				customerDTO.setCreatedDate(currentDate);
				customer.setCreatedDate(new Date());
				customer.setCustAddress(customerDTO.getCustAddress());
				customer.setCustName(customerDTO.getCustName());
				customer.setEmailId(customerDTO.getEmailId());
				customer.setPhNumber(customerDTO.getPhNumber());
				customer.setGstNumber(customerDTO.getGstNumber());
				session.saveOrUpdate(customer);
				hmOutput.put("customer", "Customer Added Successfully.");
			}
			
		} catch (Exception e) {
			hmOutput.put("customer", false);
			hmOutput.put("customer", e.getMessage());
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getProduct(int productId) throws Exception {
		Session session = null;
		//Transaction transaction = null;
		List<Product> cust = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			session = getSession();
			Criteria criteria = session.createCriteria(Product.class);
			if(productId == 0){
				cust = criteria.list();
				hmOutput.put("product", cust);
				System.out.println(cust);
			}
			else{
				criteria.add(Restrictions.eq("id", productId));
				cust = criteria.list();
				hmOutput.put("product", cust);
			}

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map saveProduct(ProductDTO productDTO) throws IllegalStateException {
		Session session = null;
		Map<String, Object> hmOutput = new HashMap<>();
		//Session session = null;
		//Transaction transaction = null;
		hmOutput.put("Success", true);
		hmOutput.put("product", "Product Added Successfully.");
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			session = getSession();
			Product product = new Product();
			List<Product> productList = null;
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", productDTO.getProductName()));
			productList = criteria.list();
			if(productList.size()>=1){
				hmOutput.put("product", "Product already exist.");
			}
			else{
			Date currentDate = new Date();
			product.setCreateDate(currentDate);
			product.setDesc(productDTO.getDesc());
			product.setProductName(productDTO.getProductName());
			product.setCgst(productDTO.getCgst());
			product.setSgst(productDTO.getSgst());
			product.setHsnCode(productDTO.getHsnCode());
			//Session session = getSession();
			session.saveOrUpdate(product);
			}
			//transaction.commit();
		} /*catch(ConstraintViolationException c){
			hmOutput.put("product", "Product already exist.");
		}*/
		catch (Exception e) {
			//transaction.rollback();
			hmOutput.put("product", false);
			hmOutput.put("product", e.getMessage());
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public Map saveOrder(OrderDTO orderDTO) throws IllegalStateException {
		Map<String, Object> hmOutput = new HashMap<>();
		Session session = null;
		//Transaction transaction = null;
		hmOutput.put("Success", true);
		hmOutput.put("order", "Order Placed Successfully.");
		try {
			session = getSession();
			Order order = new Order();
			TransactionEntity  transactionEntity = new TransactionEntity();
			//Date currentDate = new Date();
			
			Customer customer= (Customer) session.get(Customer.class,
					orderDTO.getCustomerId());
			
			Product product= (Product) session.get(Product.class,
					orderDTO.getProductId());
			
			int customerId = orderDTO.getCustomerId();
			/*Criteria  criteria  =session.createCriteria(Order.class,"order");
			//criteria.createAlias(arg0, arg1)
		    criteria.setProjection(Projections.property("customer")); //Projections.property is used to retrieve specific columns
		    List orderedCustomer = criteria.list();*/
		    
		    
		    Query query = session.createQuery("from Order where customer.id = ? order by orderPerCustomer desc");
			query.setParameter(0,customerId);
			query.setMaxResults(1);
			Order last = (Order) query.uniqueResult();
			List<Order> l = query.list();
		      if(l.size() == 0){
		    	  order.setOrderPerCustomer(1);
		    	  
		    	  	/*transactionEntity.setCreatedDate(new Date());
					transactionEntity.setCustomer(customer);
					transactionEntity.setOrder(order);
					transactionEntity.setOrderPerCustomer(1);
					transactionEntity.setRemainingAmount(orderDTO.getNetAmount());
					transactionEntity.setSubmittedAmount((long) 0);
					transactionEntity.setTotalAmount(orderDTO.getNetAmount());
					session.saveOrUpdate(transactionEntity);*/
		      }
		      else{
		    	  int odPerCust = last.getOrderPerCustomer();
		    	  order.setOrderPerCustomer(odPerCust+1);
		      }
			
			order.setAmount(orderDTO.getAmount());
			order.setCreatedDate(orderDTO.getOrderDate());
			order.setNetAmount(orderDTO.getNetAmount());
			order.setQuantity(orderDTO.getQuantity());
			order.setProduct(product);
			order.setCustomer(customer);
			session.saveOrUpdate(order);
			
			//transaction.commit();
		} catch (Exception e) {
			//transaction.rollback();
			hmOutput.put("order", false);
			hmOutput.put("Error", e.getMessage());
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getOrder() throws Exception {
		Session session = null;
		//Transaction transaction = null;
		List<Order> order = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			session = getSession();
			Criteria criteria = session.createCriteria(Order.class);
			/*criteria.setProjection(Projections.projectionList()
					.add(Projections.property("numOfGoodsOrder"))
					.addOrder(Order.desc("numOfGoodsOrder"));*/
			
			criteria.addOrder(org.hibernate.criterion.Order.desc("createdDate"));			
			order = criteria.list();
			hmOutput.put("order", order);
			System.out.println(order);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getTransaction() throws Exception {
		Session session = null;
		//Transaction transaction = null;
		List<TransactionEntity> myTransection = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			session = getSession();
			Criteria criteria = session.createCriteria(TransactionEntity.class);
			criteria.addOrder(org.hibernate.criterion.Order.desc("createdDate"));
			myTransection = criteria.list();
			hmOutput.put("transaction", myTransection);
			System.out.println(myTransection);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public Map saveTransaction(TransactionDTO transactionDTO) throws IllegalStateException {
		Map<String, Object> hmOutput = new HashMap<>();
		Session session = null;
		//Transaction transaction = null;
		hmOutput.put("Success", true);
		hmOutput.put("txn", "Successfully done!");
		try {
			session = getSession();
			TransactionEntity transactionEntity = new TransactionEntity();
			Date currentDate = new Date();
			 
			Customer customer= (Customer) session.get(Customer.class,
					transactionDTO.getCustomerId());
			
			Order order = (Order) session.get(Order.class,
					transactionDTO.getOrderId());
			
			int custId = transactionDTO.getCustomerId();
			int odpc = transactionDTO.getOrderPerCustomer();
			
			transactionEntity.setCreatedDate(currentDate);
			transactionEntity.setSubmittedAmount(transactionDTO.getDepositAmount());
			transactionEntity.setCustomer(customer);
			//transactionEntity.setOrder(order);
			
			
			Query query1 = session.createQuery("from Order where customer.id = ? and orderPerCustomer = ? order by createdDate DESC");
			query1.setParameter(0,custId);
			query1.setParameter(1,odpc);
			query1.setMaxResults(1);
			Order lastod = (Order) query1.uniqueResult();
			Long netAmount = new Long(0);
			if(lastod != null){
				netAmount = lastod.getNetAmount();
			}
			
			// netAmount = order.getNetAmount();
			int orderId = transactionDTO.getOrderPerCustomer();
			Long rAmount;
			
			Query query = session.createQuery("from TransactionEntity where customer.id = ? and orderPerCustomer = ? order by createdDate DESC");
			query.setParameter(0,custId);
			query.setParameter(1,orderId);
			query.setMaxResults(1);
			TransactionEntity last = (TransactionEntity) query.uniqueResult();
			if (last == null){
				rAmount = netAmount;
			}
			else{
			rAmount = last.getRemainingAmount();
			}
			System.out.println(rAmount);
			if(rAmount>=transactionDTO.getDepositAmount()){
				Long remainingAmount = rAmount - transactionDTO.getDepositAmount();
				transactionEntity.setRemainingAmount(remainingAmount);
				transactionEntity.setTotalAmount(netAmount);
				transactionEntity.setOrderPerCustomer(transactionDTO.getOrderPerCustomer());
				transactionEntity.setOrder(order);
				
				session.saveOrUpdate(transactionEntity);
				hmOutput.put("txn", "Amount deposited successfully!");
			}
			else{
				hmOutput.put("txn", "Deposite amount is greater then remaining amount!");
			}
			//transaction.commit();
		} catch (Exception e) {
			//transaction.rollback();
			hmOutput.put("SUCCESS", false);
			hmOutput.put("Error", e.getMessage());
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getTransactionByDate(String startDate, String endDate) throws Exception {
		Session session = null;
		List<TransactionEntity> trans = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			String from = "STR_TO_DATE('"+startDate+"','%Y-%m-%d')";
			String to = "(STR_TO_DATE('"+endDate+"','%Y-%m-%d')+1)";
			SQLQuery query = session.createSQLQuery("SELECT * FROM customer.transaction where CREATED_DATE BETWEEN "+ from +"  AND " +to+";").addEntity(TransactionEntity.class);
			trans = query.list();
			hmOutput.put("transByDate", trans);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getOrderByDate(String startDate, String endDate) throws Exception {
		Session session = null;
		List<Order> order = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			String from = "STR_TO_DATE('"+startDate+"','%Y-%m-%d')";
			String to = "(STR_TO_DATE('"+endDate+"','%Y-%m-%d'))";
			SQLQuery query = session.createSQLQuery("SELECT * FROM customer.order where CREATE_DATE BETWEEN "+ from +"  AND " +to+";").addEntity(Order.class);
			order = query.list();
			hmOutput.put("orderByDate", order);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings("rawtypes")
	public Map getCustomerRecord(int custId) throws Exception {
		Session session = null;
		List trans = null;
		List trans1 = null;
		Object[] obj = null;
		Map<String, Object> hmOutput = new HashMap<>();
		CustomerRecordDTO customerRecordDTO = new CustomerRecordDTO();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TransactionEntity.class, "trans");
			Criteria criteria1 = session.createCriteria(Order.class, "order");
			
			criteria1.createAlias("order.customer", "cust");
			ProjectionList proList = Projections.projectionList();
			ProjectionList proList1 = Projections.projectionList();
			if(custId == 0){
				proList.add(Projections.sum("submittedAmount"));
				
				proList1.add(Projections.property("netAmount"));
				//proList1.add(Projections.groupProperty("orderPerCustomer"));
				//proList1.add(Projections.groupProperty("cust.id"));
				
			    criteria.setProjection(proList);
			    criteria1.setProjection(proList1);
				
				trans = criteria.list();
				trans1 = criteria1.list();
				
				Long totalSum = new Long(0);
				Long dAmount = new Long(0);
				
				if(trans.size()>0){
					for(int i = 0 ;i<trans.size();i++){
						//obj = (Object[]) trans.get(i);				
						//dAmount = ((Long) obj[0]);
						dAmount = (Long) trans.get(i);
					}
				}
				
				if(trans1.size()>0){
					for(int i = 0 ;i<trans1.size();i++){
						//obj = (Object[]) trans1.get(i);								
						//Long total = ((Long) obj[0]);
						Long total = ((Long) trans1.get(i));
						totalSum += total;
					}
				}
				
				Long rAmount = totalSum - dAmount;
				
				customerRecordDTO.setTotalAmount(totalSum);
				customerRecordDTO.setDepositedAmount(dAmount);
				customerRecordDTO.setRemainingAmount(rAmount);
				customerRecordDTO.setCustId(custId);
			}
			else{
				criteria.createAlias("trans.customer", "cust");
				criteria.add(Restrictions.eq("cust.id", custId));
				
				criteria1.add(Restrictions.eq("cust.id", custId));
				
				proList.add(Projections.sum("submittedAmount"));
				
				proList1.add(Projections.property("netAmount"));
				//proList1.add(Projections.groupProperty("orderPerCustomer"));
				proList1.add(Projections.property("cust.custName"));
				
			    criteria.setProjection(proList);
			    criteria1.setProjection(proList1);
				
				trans = criteria.list();
				trans1 = criteria1.list();
				
				Long totalSum = new Long(0);
				Long dAmount = new Long(0);
				String custName = "";
				
				if(trans.size()>0){
					for(int i = 0 ;i<trans.size();i++){
						//obj = (Object[]) trans.get(i);				
						//dAmount = ((Long) obj[0]);
						dAmount = (Long) trans.get(i);
					}
				}
				
				if(trans1.size()>0){
					for(int i = 0 ;i<trans1.size();i++){
						obj = (Object[]) trans1.get(i);								
						Long total = ((Long) obj[0]);
						//Long total =  (Long) trans1.get(i);
						custName = (String) obj[1];
						totalSum += total;
					}
				}
				
				Long rAmount = totalSum - dAmount;
				
				customerRecordDTO.setTotalAmount(totalSum);
				customerRecordDTO.setDepositedAmount(dAmount);
				customerRecordDTO.setRemainingAmount(rAmount);
				customerRecordDTO.setCustId(custId);
				customerRecordDTO.setCustName(custName);
			}
			hmOutput.put("customerRecord", customerRecordDTO);
			System.out.println(trans);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public Map getGraphData() throws Exception {
		Session session = null;
		List<CustomerRecordDTO> customerRecordDTOs = new ArrayList<CustomerRecordDTO>();
		Object obj1 = null;
		Object[] objArr = null;
		//Transaction transaction = null;
		List myTransection = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			session = getSession();
			SQLQuery query = session.createSQLQuery("select sum(NET_AMOUNT),extract(month from CREATE_DATE) as month FROM customer.`order` group by month;");
			myTransection = query.list();
			if(myTransection.size()>0){
				for(int i = 0;i<myTransection.size();i++){
					CustomerRecordDTO customerRecordDTO = new CustomerRecordDTO();
					objArr =  (Object[]) myTransection.get(i);
					BigDecimal total = (BigDecimal) objArr[0];
					Integer month = (Integer) objArr[1];
					customerRecordDTO.setMonth(month);
					customerRecordDTO.setTotalMonthAmount(total);
					customerRecordDTOs.add(customerRecordDTO);
				}
				hmOutput.put("graphData", customerRecordDTOs);
			}
			System.out.println(myTransection);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public Map getTransactionByOrderId(int customerId, int orderPerCustId,int orderId) throws Exception {
		Session session = null;
		List myTransection = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TransactionEntity.class, "trans");
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("remainingAmount"));
			proList.add(Projections.property("totalAmount"));
			
			criteria.setProjection(proList);
			
			criteria.createAlias("trans.customer", "cust");
			criteria.add(Restrictions.eq("cust.id", customerId));
			
			criteria.createAlias("trans.order", "order");
			criteria.add(Restrictions.eq("order.id", orderId));
			criteria.add(Restrictions.eq("order.orderPerCustomer", orderPerCustId));
			
			criteria.addOrder(org.hibernate.criterion.Order.desc("createdDate"));
			myTransection = criteria.list();
			if(myTransection.size() >0){
				Object[] obj = (Object[]) myTransection.get(0);
				Long totalAmnt = new Long(0);
				Long rmnAmnt = new Long(0);
				rmnAmnt = (Long) obj[0];
				totalAmnt = (Long) obj[1];
				
				TransactionPerOrderIdDTO transactionPerOrderIdDTO = new TransactionPerOrderIdDTO();
				transactionPerOrderIdDTO.setRemainAmount(rmnAmnt);
				transactionPerOrderIdDTO.setTotalAmount(totalAmnt);
				hmOutput.put("transactionPerOrderId", transactionPerOrderIdDTO);
			}else{
				hmOutput.put("transactionPerOrderId", "empty");
			}
			
			

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public Map getCustCount() throws Exception {
		Session session = null;
		Object obj1 = null;
		List dashBoard = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			SQLQuery query = session.createSQLQuery("SELECT distinct CUSTOMER_NAME FROM customer.customer;;");
			dashBoard = query.list();
			if(dashBoard.size()>0){
				//for(int i = 0;i<dashBoard.size();i++){
					obj1 =   dashBoard.size();
				//}
				hmOutput.put("dashBoardCustCount", obj1);
			}
			System.out.println(dashBoard);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public Map getpendingOrder() throws Exception {
		Session session = null;
		Long obj1 = null;
		List dashBoard = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			SQLQuery query = session.createSQLQuery("SELECT distinct ORDER_ID FROM customer.transaction where REMAINING_AMOUNT <> 0;");
			dashBoard = query.list();
			if(dashBoard.size()>0){
				//for(int i = 0;i<dashBoard.size();i++){
					obj1 =   (long) dashBoard.size();
				//}
				hmOutput.put("dashBoardPendingOrder", obj1);
			}
			System.out.println(dashBoard);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public Map getclearedOrder() throws Exception {
		Session session = null;
		Long obj1 = null;
		List dashBoard = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			SQLQuery query = session.createSQLQuery("SELECT distinct ORDER_ID FROM customer.transaction where REMAINING_AMOUNT = 0;");
			dashBoard = query.list();
			if(dashBoard.size()>0){
				//for(int i = 0;i<dashBoard.size();i++){
					obj1 =   (long) dashBoard.size();
				//}
				hmOutput.put("dashBoardClearedOrder", obj1);
			}
			System.out.println(dashBoard);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public Map getTotalOrder() throws Exception {
		Session session = null;
		Long obj1 = null;
		List dashBoard = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			SQLQuery query = session.createSQLQuery("SELECT distinct ORDER_ID FROM customer.`order`;");
			dashBoard = query.list();
			if(dashBoard.size()>0){
				//for(int i = 0;i<dashBoard.size();i++){
					obj1 =   (long) dashBoard.size();
				//}
				hmOutput.put("dashBoardTotalOrder", obj1);
			}
			System.out.println(dashBoard);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public Map getYearData() throws Exception {
		Session session = null;
		List<YearSaleDTO> yearSaleDTOs = new ArrayList<YearSaleDTO>();
		Object obj1 = null;
		Object[] objArr = null;
		//Transaction transaction = null;
		List myTransection = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			session = getSession();
			SQLQuery query = session.createSQLQuery("select sum(NET_AMOUNT),extract(year from CREATE_DATE) as year FROM customer.`order` group by year;");
			myTransection = query.list();
			if(myTransection.size()>0){
				for(int i = 0;i<myTransection.size();i++){
					YearSaleDTO yearSaleDTO = new YearSaleDTO();
					objArr =  (Object[]) myTransection.get(i);
					BigDecimal total = (BigDecimal) objArr[0];
					Integer year = (Integer) objArr[1];
					yearSaleDTO.setYear(year);
					yearSaleDTO.setAmount(total);
					yearSaleDTOs.add(yearSaleDTO);
				}
				hmOutput.put("yearData", yearSaleDTOs);
			}
			System.out.println(myTransection);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public Map getMonthData(int year) throws Exception {
		Session session = null;
		List<MonthSaleDTO> monthSaleDTOs = new ArrayList<MonthSaleDTO>();
		Object obj1 = null;
		Object[] objArr = null;
		//Transaction transaction = null;
		List myTransection = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			session = getSession();
			
			SQLQuery query = session.createSQLQuery("select sum(NET_AMOUNT),monthname(CREATE_DATE) as month FROM customer.`order` where year(CREATE_DATE) = ? group by month(CREATE_DATE);");
			query.setParameter(0,year);
			myTransection = query.list();
			if(myTransection.size()>0){
				for(int i = 0;i<myTransection.size();i++){
					MonthSaleDTO monthSaleDTO = new MonthSaleDTO();
					objArr =  (Object[]) myTransection.get(i);
					BigDecimal total = (BigDecimal) objArr[0];
					String month = (String) objArr[1];
					monthSaleDTO.setMonth(month);
					monthSaleDTO.setAmount(total);
					monthSaleDTOs.add(monthSaleDTO);
				}
				hmOutput.put("monthData", monthSaleDTOs);
			}
			System.out.println(myTransection);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public Map getMonthlyQty(int year,String month) throws Exception {
		Session session = null;
		List<MonthSaleDTO> monthQtyDTOs = new ArrayList<MonthSaleDTO>();
		Object obj1 = null;
		Object[] objArr = null;
		//Transaction transaction = null;
		List myTransection = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			session = getSession();
			
			SQLQuery query = session.createSQLQuery("select p.product_NAME, sum(Quantity), sum(o.NET_AMOUNT) from customer.`order` o "
			+" join customer.product p on p.PRODUCT_ID = o.PRODUCT_ID where year(o.CREATE_DATE) = ? and monthname(o.CREATE_DATE) = ? group by(o.PRODUCT_ID);");
			query.setParameter(0,year);
			query.setParameter(1,month);
			myTransection = query.list();
			if(myTransection.size()>0){
				for(int i = 0;i<myTransection.size();i++){
					MonthSaleDTO monthQtyDTO = new MonthSaleDTO();
					objArr =  (Object[]) myTransection.get(i);
					String productName = (String) objArr[0];
					BigDecimal qty = (BigDecimal) objArr[1];
					BigDecimal prodMonthAmount = (BigDecimal) objArr[2];
					monthQtyDTO.setMonthProdAmount(prodMonthAmount);
					monthQtyDTO.setProductName(productName);
					monthQtyDTO.setQty(qty);
					monthQtyDTOs.add(monthQtyDTO);
				}
				hmOutput.put("monthQtyData", monthQtyDTOs);
			}
			System.out.println(myTransection);

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public Map getDashBoard(int year,String month) throws Exception {
		Session session = null;
		DashBoardDTO dashBoardDTO = new DashBoardDTO();
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			//hmOutput.put("CustCount",getCustCount());
			//hmOutput.put("pendingOrder",getpendingOrder());
			hmOutput = getCustCount();
			int custCount  = (int) hmOutput.get("dashBoardCustCount");
			
			hmOutput = getpendingOrder();
			Long pendingOrder = (Long) hmOutput.get("dashBoardPendingOrder");
			
			hmOutput = getclearedOrder();
			Long clearedOrder = (Long) hmOutput.get("dashBoardClearedOrder");
			
			hmOutput = getTotalOrder();
			Long totalOrder = (Long) hmOutput.get("dashBoardTotalOrder");
			
			hmOutput = getYearData();
			List yearData = (List) hmOutput.get("yearData");
			
			hmOutput = getMonthData(year);
			List monthData = (List) hmOutput.get("monthData");
			
			hmOutput = getMonthlyQty(year,month);
			List monthlyQty = (List) hmOutput.get("monthQtyData");
			
			hmOutput = getCustPendingAmnt();
			List pendingCustAmnt = (List) hmOutput.get("custPendingAmnt");
			
			dashBoardDTO.setPendingOrder(pendingOrder);
			dashBoardDTO.setCustCount(custCount);
			dashBoardDTO.setClearedOrder(clearedOrder);
			dashBoardDTO.setTotalOrder(totalOrder);
			dashBoardDTO.setYearSaleList(yearData);
			dashBoardDTO.setMonthSaleList(monthData);
			dashBoardDTO.setMonthQtyist(monthlyQty);
			dashBoardDTO.setCustPendingAmnt(pendingCustAmnt);
			
			
				hmOutput.put("dashBoard", dashBoardDTO);
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public Map getBillDetails(String startDate, String endDate) throws Exception {
		Session session = null;
		List<BillDAO> bills = new ArrayList<BillDAO>();
		Object obj1 = null;
		Object[] objArr = null;
		List myTransection = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(BillDAO.class);
			if(startDate.isEmpty() && endDate.isEmpty()){
				criteria.add(Restrictions.eq("deletedFlag", 1));
				bills = criteria.list();
				
				/*	BillDAO billDAO = new BillDAO();
				SQLQuery query = session.createSQLQuery("SELECT PARTY_NAME, QUANTITY, PRODUCT_NAME, AMOUNT, TOTAL_AMOUNT, CREATED_DATE, INVOICE_NO FROM customer.bill where IS_DELETED = 1;");
				myTransection = query.list();
				if(myTransection.size()>0){
					for(int i = 0;i<myTransection.size();i++){
						MonthSaleDTO monthSaleDTO = new MonthSaleDTO();
						objArr =  (Object[]) myTransection.get(i);
						String partyName = (String) objArr[0];
						Integer qty = (Integer) objArr[1];
						String productName = (String) objArr[2];
						BigDecimal amount = (BigDecimal) objArr[3];
						BigDecimal totalAmount = (BigDecimal) objArr[4];
						Date billDate = (Date) objArr[5];
						BigDecimal invoiceNo = (BigDecimal)objArr[6];
						
						billDAO.setAmount(amount);
						billDAO.setBillDate(billDate);
						billDAO.setInvoiceNo(invoiceNo);
						billDAO.setItem(productName);
						billDAO.setPartyName(partyName);
						billDAO.setQty(qty);
						billDAO.setTotalAmount(totalAmount);
						bills.add(billDAO);
					}
					hmOutput.put("bills", bills);
				}*/
				hmOutput.put("bills", bills);
			}
			if(!startDate.isEmpty() && !endDate.isEmpty()){
				String from = "STR_TO_DATE('"+startDate+"','%Y-%m-%d')";
				String to = "(STR_TO_DATE('"+endDate+"','%Y-%m-%d'))";
				SQLQuery query = session.createSQLQuery("SELECT * FROM customer.bill where CREATED_DATE BETWEEN "+ from +"  AND " +to+" AND DELETED_FLAG = 1;").addEntity(BillDAO.class);
				bills = query.list();
				hmOutput.put("bills", bills);
			}
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public Map deleteBillByInvoice(Long invoiceId) throws Exception {
		Session session = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			//Query query = session.createQuery("delete from BillDAO where invoiceNo = ?");
			Query query = session.createQuery("update BillDAO set deletedFlag = 0 where invoiceNo = ?");
			BigDecimal d = new BigDecimal(invoiceId);
			query.setParameter(0,d);
			int result = query.executeUpdate();
			hmOutput.put("bills", "Bill with invoice no. " +invoiceId+" has been deleted");
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	
	@SuppressWarnings({ "rawtypes" })
	public Map addBillDetails(List<BillDTO> billDTOs) throws IllegalStateException {
		Map<String, Object> hmOutput = new HashMap<>();
		Session session = null;
		hmOutput.put("Success", true);
		try {
			session = getSession();
			@SuppressWarnings("unused")
			Criteria criteria = session.createCriteria(BillDAO.class);
			for(int i = 0 ;i<billDTOs.size();i++){
				BillDAO billDAO = new BillDAO();
				BillDTO billDTO = billDTOs.get(i);
				billDAO.setPartyName(billDTO.getPartyName());
				billDAO.setItem(billDTO.getItem());
				billDAO.setAmount(billDTO.getAmount());
				billDAO.setBillDate(billDTO.getBillDate());
				billDAO.setInvoiceNo(billDTO.getInvoiceNo());
				billDAO.setQty(billDTO.getQty());
				billDAO.setTotalAmount(billDTO.getTotalAmount());
				billDAO.setDeletedFlag(1);
				session.saveOrUpdate(billDAO);
				hmOutput.put("bill", "Bill Added Successfully.");
			}
		} catch (Exception e) {
			hmOutput.put("bill", false);
			hmOutput.put("bill", e.getMessage());
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public Map getCustPendingAmnt() throws Exception {
		Session session = null;
		List<CustomerRecordDTO> customerRecordDTOs = new ArrayList<CustomerRecordDTO>();
		Object obj1 = null;
		Object[] objArr = null;
		List totalAmntQueryList = null;
		List depositedAmntQueryList = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			
			SQLQuery totalAmntQuery = session.createSQLQuery("select c.CUSTOMER_NAME, sum(o.NET_AMOUNT) from customer.customer c join "
							+" customer.order o on c.CUSTOMER_ID = o.CUSTOMER_ID group by c.CUSTOMER_ID;");
			
			SQLQuery depositedAmntQuery = session.createSQLQuery("select c.CUSTOMER_NAME, sum(t.SUBMITTED_AMOUNT) from customer.customer c join "
									+" customer.transaction t on c.CUSTOMER_ID = t.CUSTOMER_ID group by c.CUSTOMER_ID;");
			
			totalAmntQueryList = totalAmntQuery.list();
			depositedAmntQueryList = depositedAmntQuery.list();
			
			
			/*if(myTransection.size()>0){
				for(int i = 0;i<myTransection.size();i++){
					CustomerRecordDTO customerRecordDTO = new CustomerRecordDTO();
					objArr =  (Object[]) myTransection.get(i);
					String custName = (String) objArr[0];
					BigDecimal totalAmnt = (BigDecimal) objArr[1];
					customerRecordDTO.setTotalMonthAmount(totalAmnt);
					customerRecordDTO.setCustName(custName);
					customerRecordDTOs.add(customerRecordDTO);
				}
				hmOutput.put("custPendingAmnt", customerRecordDTOs);
			}*/
		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public Map userAuthenticate(UserDTO userDTO) throws Exception {
		Session session = null;
		List userList = null;
		Map<String, Object> hmOutput = new HashMap<>();
		hmOutput.put("Success", true);
		hmOutput.put("Success", "Successfully done!");
		try {
			session = getSession();
			//SQLQuery query = session.createSQLQuery("SELECT distinct ORDER_ID FROM customer.`order`;");
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("userName", userDTO.getUserName()))
					.add(Restrictions.eq("password", userDTO.getPassword()));;
			userList = criteria.list();
			if(userList.size()>0){
					//int size =  userList.size();
				hmOutput.put("userAuth", "You are successfully logged in");
			}
			else{
				hmOutput.put("userAuth", "Incorrect username or password");
			}

		} catch (Exception e) {
			hmOutput.put("Success", false);
			hmOutput.put("Success", e.getMessage());
			// _logger.error("get department Exception DAO- ", e);
		} finally {
			//session.close();
		}
		return hmOutput;
	}
	
}
