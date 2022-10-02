package com.miniProject.cust_login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.miniProject.Util.DBUtil;
import com.miniProject.usecases.CreateNewAccount;
import com.miniProject.usecases.DeleteAccount;
import com.miniProject.usecases.TransactionHistory;
import com.miniProject.usecases.TransferMoney;

public class LoginCustomer {

public static void customerLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the username as : customer");
		
		String username = sc.nextLine();
		
		System.out.println("Enter teh password as : customer");
		
		String password = sc.nextLine();
		
		try(Connection conn =  DBUtil.provideConnection()) {
			
		PreparedStatement ps = conn.prepareStatement("select * from login_customer where username = ? and password = ?");
			
		ps.setString(1, username);
		ps.setString(2, password);
		
	  ResultSet rs = ps.executeQuery();
	  
	  if(rs.next()) {
		  System.out.println("Login successfull");
		  
		  while(true) {
			  System.out.println("Choose the option of perfrom the below metioned operations");
			  System.out.println("1. Transfer Money");
			  System.out.println("2. Transaction history");
			  System.out.println("3. To Exit");
			  System.out.println("********************************************");
			  
			  Scanner input = new Scanner(System.in);
				
			  int i = input.nextInt();
				
			  if(i ==3) {
				  System.out.println("Logged out successfully");
				  break;
			  }
			  switch (i) {
			  
			  case 1: TransferMoney.main(null);
			  break;
				
			  case 2: TransactionHistory.main(null);
			  break;
			  
			  default: System.out.println("Invalid input");
				
			  }
		  }
		  
		  
		  
	  }else {
		  System.out.println("Invalid username or password");
	  }
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
