package com.miniProject.usecases;

import java.util.List;
import java.util.Scanner;

import com.miniProject.bean.MoneyTransfer;
import com.miniProject.dao.AccountantDao;
import com.miniProject.dao.AccountantDaoImpl;
import com.miniProject.exception.CustomerException;

public class TransactionHistory {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Enter the money sender account number");
			int sender = sc.nextInt();
			
			AccountantDao accDao = new AccountantDaoImpl();
			try {
				List<MoneyTransfer> moneyTransfer =accDao.trasactionHistory(sender);
				
				moneyTransfer.forEach(s -> System.out.println(s));
				
				
			} catch (CustomerException e) {
				
				System.out.println(e.getMessage());
			}
		

	}

}
