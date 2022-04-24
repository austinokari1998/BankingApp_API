package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.accounts_service;
import  com.example.demo.services.withdraw;

import DTO.accountDTO;
import com.example.demo.services.deposit;

@RestController
public class accountsController {
	@Autowired
	private accounts_service accserve;
	
	
	@GetMapping("/all_accounts")
	public void all_accounts() {
		accserve.all_accounts();
		
	}
	@PostMapping("/new_account")
	public void create_account(@RequestBody accountDTO account) {
		accserve.create_account(account);
	}
	@PostMapping("/deposit")
	public void deposit(@RequestBody deposit deposit) {
		accserve.deposit_cash(deposit);
		
		
	}
	@PostMapping("/withdraw")
	public void withdraw(@RequestBody withdraw withdrawalre) {
		accserve.withdrawal(withdrawalre);
	}
	@GetMapping("/information")
	public void accs_infor(@RequestBody accountDTO account) {
		accserve.accountdetails(account);
		
		
	}

}
