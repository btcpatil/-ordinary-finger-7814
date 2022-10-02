package com.miniProject.usecases;

import java.util.Scanner;

import com.miniProject.bean.Customer;
import com.miniProject.dao.AccountantDao;
import com.miniProject.dao.AccountantDaoImpl;

public class CreateNewAccount {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the customer id");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the customer name");
		String name = sc.nextLine();
		
		System.out.println("Enter the customer phone number");
		String phone = sc.nextLine();
		
		System.out.println("Enter the customer email address");
		String email = sc.nextLine();
		
		System.out.println("Enter the today's date in yyyy-mm-dd format");
		String date = sc.nextLine();
		
		System.out.println("Enter the deposit amount");
		int bal = sc.nextInt();
		
		AccountantDao accDao = new AccountantDaoImpl();
		
		Customer cusDeatails = new Customer(id, name, phone, email, date, bal);
		
		String message = accDao.createNewAccount(cusDeatails);
		
		System.out.println(message);
		
		System.out.println("*************************************");
		System.out.println();
	}

}
