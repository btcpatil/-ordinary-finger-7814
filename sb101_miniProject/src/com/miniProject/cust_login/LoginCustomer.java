package com.miniProject.cust_login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.miniProject.Util.DBUtil;

public class LoginCustomer {

public static void customerLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the username as : customer");
		
		String username = sc.nextLine();
		
		System.out.println("Enter teh password as : customer");
		
		String password = sc.nextLine();
		
		try(Connection conn =  DBUtil.provideConnection()) {
			
		PreparedStatement ps = conn.prepareStatement("select * from login_accountant where username = ? and password = ?");
			
		ps.setString(1, username);
		ps.setString(2, password);
		
	  ResultSet rs = ps.executeQuery();
	  
	  if(rs.next()) {
		  System.out.println("Login successfull");
		  
		  
	  }else {
		  System.out.println("Invalid username or password");
	  }
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
