package com.example.demo.services;

public class withdraw {
	private String account_number;
	private int amount;
	
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public withdraw() {
		super();
	}
	public withdraw(String account_number, int amount) {
		super();
		this.account_number = account_number;
		this.amount = amount;
	}
	
	

}
