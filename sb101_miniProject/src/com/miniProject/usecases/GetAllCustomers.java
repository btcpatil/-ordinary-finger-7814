package com.miniProject.usecases;

import java.util.List;

import com.miniProject.bean.Customer;
import com.miniProject.dao.AccountantDao;
import com.miniProject.dao.AccountantDaoImpl;
import com.miniProject.exception.CustomerException;

public class GetAllCustomers {

	public static void main(String[] args) {
		
		AccountantDao accDao = new AccountantDaoImpl();
		
		try {
			List<Customer> customers =accDao.getallCustomer();
			
			customers.forEach(s -> System.out.println(s));
			
			
		} catch (CustomerException e) {
			
			System.out.println(e.getMessage());
		}
		
		System.out.println("*************************************");
		System.out.println();

	}

}
