package com.example.demo.services;


public class deposit {
	
	
	public deposit() {
		super();
	}
	public deposit(String account_number, Integer amount) {
		super();
		this.account_number = account_number;
		this.amount = amount;
	}
	private String account_number;
	private Integer amount;
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	

}
