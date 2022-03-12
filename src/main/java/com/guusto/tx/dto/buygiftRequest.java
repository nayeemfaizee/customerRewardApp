package com.guusto.tx.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class buygiftRequest {

	private String clientId;
	private List<orderDetails> orderDetails = null;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getClientId() {
	return clientId;
	}

	public void setClientId(String clientId) {
	this.clientId = clientId;
	}

	public List<orderDetails> getorderDetails() {
	return orderDetails;
	}

	public void setOrderDetails(List<orderDetails> orderDetails) {
	this.orderDetails = orderDetails;
	}

	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	
	
}
