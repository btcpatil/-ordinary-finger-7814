package com.miniProject.dao;

import java.util.List;

import com.miniProject.bean.Customer;
import com.miniProject.exception.CustomerException;

public interface AccountantDao {

	public String createNewAccount(Customer customer);
	
	public String editphoneNumber(String phone, int accountNo);
	
	public String removeAccount(int accountNo);
	
	public Customer getCustomerByAccountNo(int accountNo) throws CustomerException;
	
	public List<Customer> getallCustomer() throws CustomerException;
	
	public String transferAmount(int amount, String reci_acc, String sender_acc)throws CustomerException;
}
