package com.org.dom;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.org.dto.CustomerDTO;


/**
 * 
 *
 */
@XmlRootElement(name = "requestBody")
@XmlType(propOrder = { "customerDTO"})
public class PortalRequestBody  {
	private CustomerDTO customerDTO;

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	
	
	
	
			

}
