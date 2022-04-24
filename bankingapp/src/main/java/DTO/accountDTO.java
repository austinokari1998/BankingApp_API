package DTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;



import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="accounts")
public class accountDTO  {
	@Column(name="accountType")
	@Enumerated(EnumType.STRING)
	private accountDTO account_type;
	@Column(name="account_number")
	@Id
	private String account_number;
	@Column(name="username")
	private String Username;
	
	@Column(name="account_balance")
	private double balance;
	@Column(name="account_password")
	private String account_password;
	public accountDTO(accountDTO account_type, String account_number,String Username, double balance, String account_password) {
		super();
		this.account_type = account_type;
		this.account_number = account_number;
		this.Username=Username;
		this.balance = balance;
		this.account_password = account_password;
	}
	
	public accountDTO() {
		super();
	}

	public accountDTO getAccount_type() {
		return account_type;
	}

	public void setAccount_type(accountDTO account_type) {
		this.account_type = account_type;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String Username) {
		this.Username=Username;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccount_password() {
		return account_password;
	}

	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}
	public void deposit(Integer amount) {
		balance+=amount;
		
	}
	public void withdraw(Integer amount) {
		balance-=amount;
	}
	
	
	
}
