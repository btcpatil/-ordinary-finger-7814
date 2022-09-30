package com.miniProject.usecases;

import java.util.Scanner;

import com.miniProject.dao.AccountantDao;
import com.miniProject.dao.AccountantDaoImpl;

public class EditPhoneNumber {

	public static void main(String[] args) {
		
       Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the customer phone number");
		String phone = sc.nextLine();
		
		System.out.println("Enter the customer account number");
		int account = sc.nextInt();
		
		AccountantDao accDao = new AccountantDaoImpl();
		
		String result = accDao.editphoneNumber(phone, account);
		
		System.out.println(result);
		

	}

}
