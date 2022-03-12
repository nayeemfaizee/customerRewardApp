package com.guusto.tx.dto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class orderDetails {
	private String amount;
	private String quantity;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getAmount() {
	return amount;
	}

	public void setAmount(String amount) {
	this.amount = amount;
	}

	public String getQuantity() {
	return quantity;
	}

	public void setQuantity(String quantity) {
	this.quantity = quantity;
	}

	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
  

}
