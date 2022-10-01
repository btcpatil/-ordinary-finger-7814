package com.miniProject.home;

import java.util.Scanner;

import com.miniProject.acc_login.Accountant;
import com.miniProject.cust_login.LoginCustomer;

public class Welcome {
              
	public static void main(String[] args) {
		
		System.out.println("Welcome the online banking system");
		
		System.out.println("--------------------------------------");
		System.out.println("Choose the option");
		System.out.println("1. Login as accountant");
		System.out.println("2. Login as customer");
		
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();
		switch(option) {
		case 1: Accountant.accountantLogin();
		break;
		case 2: LoginCustomer.customerLogin();
		break;
		default: System.out.println("Invalid option");
		}

	}

}
