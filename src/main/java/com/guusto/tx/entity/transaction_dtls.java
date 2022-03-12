package com.guusto.tx.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
public class transaction_dtls {

	@Id
	@GeneratedValue
	private Integer txnId;
	private Integer clientId;
	private int quantity;
	private Double amount;
	private double balance;
	private double remindbalance;
	private int gift;
	public Integer getTxnId() {
		return txnId;
	}
	public void setTxnId(Integer txnId) {
		this.txnId = txnId;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getRemindbalance() {
		return remindbalance;
	}
	public void setRemindbalance(double remindbalance) {
		this.remindbalance = remindbalance;
	}
	public int getGift() {
		return gift;
	}
	public void setGift(int gift) {
		this.gift = gift;
	}	
	
	
}
