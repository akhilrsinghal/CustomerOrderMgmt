package com.org.dom;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 *
 */
@XmlRootElement(name = "serviceRequest")
@XmlType(propOrder = { "requestHeader", "requestBody" })
public class PortalRequest  {
	/**
	 * This field contains the header information of the request.
	 */		
	private PortalRequestBody requestBody;
		

	@XmlElement(name = "requestBody")
	public PortalRequestBody getRequestBody() {
			return requestBody;
	}

	public void setRequestBody(PortalRequestBody requestBody) {
		this.requestBody = requestBody;
	}
	
	/*@Override
	public String toXMLString(){
		return CommonUtil.objectToXMLString(PortalRequest.class, this);	
	}
	
	@Override
	public String toJSONString(){
		return CommonUtil.objectToJSONString(this);	
	}*/
}
