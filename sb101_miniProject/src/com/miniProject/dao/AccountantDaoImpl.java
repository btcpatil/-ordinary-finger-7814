package com.miniProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.miniProject.Util.DBUtil;
import com.miniProject.bean.Customer;
import com.miniProject.exception.CustomerException;

public class AccountantDaoImpl implements AccountantDao{

	@Override
	public String createNewAccount(Customer customer) {
		
		String message = "Account is not created";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into customer(cust_id,name, phone, email, acc_activation_date,total_bal) values(?,?,?,?,?,?) ");
			
			ps.setInt(1, customer.getCust_id());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getAcc_active_date());
			ps.setInt(6, customer.getBalance());
			
			int x =ps.executeUpdate();
			
			if(x>0) {
				message = "Account created successfully";
			}else {
				message = "Invalid credencials";
			}
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public String editphoneNumber(String phone,int accountNo) {
		
		String message = "Phone number is not edited";
		
       try(Connection conn = DBUtil.provideConnection()) {
	
			PreparedStatement ps = conn.prepareStatement("update customer set phone = ? where account_no = ?");
			
			ps.setString(1, phone);
			ps.setInt(2, accountNo);
			
			int x =ps.executeUpdate();
			
			
			if(x>0) {
				message = "Phone number is updated successfully";
			}else {
				message = "Account doesn't exists";
			}
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		return message;
		
	}

	@Override
	public String removeAccount(int accountNo) {
		
		String message = "Account is not deleted";
		
	       try(Connection conn = DBUtil.provideConnection()) {
		
				PreparedStatement ps = conn.prepareStatement("delete from customer where account_no = ?");
				
				ps.setInt(1, accountNo);
				
				int x =ps.executeUpdate();
				
				if(x>0) {
					message = "Account is deleted successfully";
				}else {
					message = "Account doesn't exists";
				}
				
			} catch (SQLException e) {
				message = e.getMessage();
			}
			return message;
	}

	@Override
	public Customer getCustomerByAccountNo(int accountNo) throws CustomerException {
		
		Customer customer = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from customer where account_no = ?");
			
			ps.setInt(1, accountNo);
			
		    ResultSet rs = ps.executeQuery();
		    
		    if(rs.next()) {
		    	int id = rs.getInt("cust_id");
		    	int accNo = rs.getInt("account_no");
		    	String name = rs.getString("name");
		    	String  phone = rs.getString("phone");
		    	String  email = rs.getString("email");
		    	String  date = rs.getString("acc_activation_date");
		    	int bal = rs.getInt("total_bal");
		    	
		    	customer= new Customer();
		    	customer.setAcc_active_date(date);
		    	customer.setAccount_no(accNo);
		    	customer.setBalance(bal);
		    	customer.setCust_id(id);
		    	customer.setEmail(email);
		    	customer.setName(name);
		    	customer.setPhone(phone);
		    	
		    	
		    	
		    }else {
		    	throw new CustomerException("Customer doesn't exists with :"+ accountNo);
		    }
		    
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		
		return customer;
	}

	@Override
	public List<Customer> getallCustomer() throws CustomerException {
		
		List<Customer> list = new ArrayList<>();
		
    try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from customer ");
			
			
			
		    ResultSet rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    	int id = rs.getInt("cust_id");
		    	int accNo = rs.getInt("account_no");
		    	String name = rs.getString("name");
		    	String  phone = rs.getString("phone");
		    	String  email = rs.getString("email");
		    	String  date = rs.getString("acc_activation_date");
		    	int bal = rs.getInt("total_bal");
		    	
		    	Customer customer= new Customer();
		    	customer.setAcc_active_date(date);
		    	customer.setAccount_no(accNo);
		    	customer.setBalance(bal);
		    	customer.setCust_id(id);
		    	customer.setEmail(email);
		    	customer.setName(name);
		    	customer.setPhone(phone);
		    	
		    	list.add(customer);
		    	
		    }
		    
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
    
       if(list.size()==0) {
    	   throw new CustomerException("No customer found :(");
       }

		return list;
	}

	@Override
	public String transferAmount(int amount, String reci_acc, String sender_acc) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
