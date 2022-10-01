package com.miniProject.usecases;

import java.util.Scanner;

import com.miniProject.bean.MoneyTransfer;
import com.miniProject.dao.AccountantDao;
import com.miniProject.dao.AccountantDaoImpl;
import com.miniProject.exception.CustomerException;

public class TransferMoney {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Enter the money sender account number");
			int sender = sc.nextInt();
			
			System.out.println("Enter the money reciver account number");
			int reciver = sc.nextInt();
			
			System.out.println("Enter the amount to be trasnfered");
			int amount = sc.nextInt();
			
			System.out.println("Enter the date to transaction in yyyy-mm-dd format");
			String date = sc.next();
			
			MoneyTransfer  mt = new MoneyTransfer(amount, sender, reciver, date);
			
			AccountantDao accDao = new AccountantDaoImpl();
			
			try {
			  String result = accDao.transferAmount(mt);
			  
			  System.out.println(result);
				
				
			} catch (CustomerException e) {
				
				System.out.println(e.getMessage());
			}

	}

}
