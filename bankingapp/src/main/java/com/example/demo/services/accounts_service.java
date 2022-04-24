package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.RequestNotFound;
import com.example.demo.repository.accountsRepository;

import DTO.accountDTO;

@Service
public class accounts_service implements UserDetailsService {
	@Autowired
	private accountsRepository accountrepo;
	
	List<accountDTO> all_accounts=new ArrayList<>();
	//to have the list of accounts the user has displayed
	public String generateAccNo() {
		Random rd=new Random();
		char[] chr=new char[12];
		chr[0] = (char) (rd.nextInt(11) + 'A');
        for(int i=1; i<chr.length; i++) {
            chr[i] = (char) (rd.nextInt(10) + '0');
        }
        return String.valueOf(chr);
	}
	public List<accountDTO> all_accounts() {
		
		accountrepo.findAll().forEach(all_accounts::add);
		return all_accounts;
		
		
	}
	
	public void create_account(accountDTO account) {
	//we shall have the account number automated and initial balance set at 0.00 	
	account.setAccount_number(generateAccNo());
	account.setBalance(0.00);
	accountrepo.save(account);
	}
		
	
	public void deposit_cash(deposit account) {
		for(accountDTO accounts:all_accounts) {
			
			if(!accounts.getAccount_number().equals(account.getAccount_number())) {
				throw new RequestNotFound("the account details you just specified do not exist");
				
				
				
				
			}
			accounts.deposit(account.getAmount());
		
		
		
	
		
	}}
	
		public void withdrawal(withdraw account) {
			for(accountDTO acc:all_accounts) {
				if(!acc.getAccount_number().equals(account.getAccount_number())) {
					throw new RequestNotFound("the account details you have do not exist");
				}
				acc.withdraw(account.getAmount());
				
			}
			
			
		}
		public void accountdetails(accountDTO account) {
			
			for(accountDTO acc:all_accounts) {
				if(!acc.getAccount_number().equals(account.getAccount_number())){
					throw new RequestNotFound("the user account number is either wrong or non-existent");
				}
				else if(!acc.getAccount_password().equals(account.getAccount_password())) {
					throw new RequestNotFound("the password you just entered is wrong");
				}
				System.out.println(acc.getAccount_type());
				System.out.println(acc.getAccount_number());

			}
			
		}
		@Override
		public UserDetails loadUserByUsername(String Username) throws UsernameNotFoundException {
			accountDTO account=accountrepo.findByUsername(Username);
			if(account==null) {
				
			throw new UsernameNotFoundException(Username);
		
		}
	
			return new MyaccountDetails(account);

	
	
	
		}

}
