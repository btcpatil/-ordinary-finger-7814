package com.miniProject.usecases;

import java.util.Scanner;

import com.miniProject.bean.Customer;
import com.miniProject.dao.AccountantDao;
import com.miniProject.dao.AccountantDaoImpl;
import com.miniProject.exception.CustomerException;

public class GetCustomerByAccountNo {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the customer account number");
		int account = sc.nextInt();
		
		AccountantDao accDao = new AccountantDaoImpl();
		
		Customer result;
		try {
			result = accDao.getCustomerByAccountNo(account);
			
			System.out.println(result);
		} catch (CustomerException e) {
			
			System.out.println(e.getMessage());
		}
		
		System.out.println("*************************************");
		System.out.println();

	}

}
