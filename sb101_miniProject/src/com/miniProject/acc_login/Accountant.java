package com.miniProject.acc_login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.miniProject.Util.DBUtil;
import com.miniProject.usecases.CreateNewAccount;
import com.miniProject.usecases.DeleteAccount;
import com.miniProject.usecases.EditPhoneNumber;
import com.miniProject.usecases.GetAllCustomers;
import com.miniProject.usecases.GetCustomerByAccountNo;

public class Accountant {

	public static void accountantLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the username as : admin");
		
		String username = sc.nextLine();
		
		System.out.println("Enter teh password as : admin");
		
		String password = sc.nextLine();
		
		try(Connection conn =  DBUtil.provideConnection()) {
			
		PreparedStatement ps = conn.prepareStatement("select * from login_accountant where username = ? and password = ?");
			
		ps.setString(1, username);
		ps.setString(2, password);
		
	  ResultSet rs = ps.executeQuery();
	  
	  if(rs.next()) {
		  System.out.println("Login successfull");
		  
		 System.out.println("Choose the option of perfrom the below metioned operations");
		 System.out.println("1. Create a new account");
		 System.out.println("2. Delete an account");
		 System.out.println("3. Edit phone number in the existing account");
		 System.out.println("4. Get all customer information");
		 System.out.println("5. Get the customer information by accout number");
		 
		 System.out.println("********************************************");
		 
		 
		Scanner input = new Scanner(System.in);
		
		 int i = input.nextInt();
		
		switch (i) {
		case 1: CreateNewAccount.main(null);
		break;
		
		case 2: DeleteAccount.main(null);
		break;
		
		case 3: EditPhoneNumber.main(null);
		break;
		
		case 4: GetAllCustomers.main(null);
		break;
		
		case 5: GetCustomerByAccountNo.main(null);
		break;
		
		default:
			System.out.println("Invalid input");
		}
		  
	  }else {
		  System.out.println("Invalid username or password");
	  }
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
