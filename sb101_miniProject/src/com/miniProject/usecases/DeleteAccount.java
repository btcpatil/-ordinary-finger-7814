package com.miniProject.usecases;

import java.util.Scanner;

import com.miniProject.dao.AccountantDao;
import com.miniProject.dao.AccountantDaoImpl;

public class DeleteAccount {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the customer account number");
		int account = sc.nextInt();
		
		AccountantDao accDao = new AccountantDaoImpl();
		
		String result = accDao.removeAccount(account);

		System.out.println(result);
		
		System.out.println("*************************************");
		System.out.println();
	}

}
