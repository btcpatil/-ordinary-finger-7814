package com.miniProject.bean;

public class Customer {
	
	private int cust_id;
	private int account_no;
	private String name;
	private String phone;
	private String email;
	private String acc_active_date;
	private int balance;
	
	public Customer() {
		
	}
	
	public Customer(int cust_id, String name, String phone, String email, String acc_active_date, int balance) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.acc_active_date = acc_active_date;
		this.balance = balance;
	}
 
	public int getAccount_no() {
		return account_no;
	}


	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public int getCust_id() {
		return cust_id;
	}


	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAcc_active_date() {
		return acc_active_date;
	}


	public void setAcc_active_date(String acc_active_date) {
		this.acc_active_date = acc_active_date;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", account_no=" + account_no + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", acc_active_date=" + acc_active_date + ", balance=" + balance + "]";
	}


	
	

}
