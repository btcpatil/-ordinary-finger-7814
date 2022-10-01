package com.miniProject.bean;

public class MoneyTransfer {

  private int amount;
  private int sender_acc;
  private int reciver_acc;
  private String date;
  
  public MoneyTransfer(int amount, int sender_acc, int reciver_acc, String date) {
		super();
		this.amount = amount;
		this.sender_acc = sender_acc;
		this.reciver_acc = reciver_acc;
		this.date = date;
	}
  
	public int getAmount() {
	  return amount;
    }

	public void setAmount(int amount) {
		this.amount = amount;
	}



	public int getSender_acc() {
		return sender_acc;
	}

	public void setSender_acc(int sender_acc) {
		this.sender_acc = sender_acc;
	}

	public int getReciver_acc() {
		return reciver_acc;
	}

	public void setReciver_acc(int reciver_acc) {
		this.reciver_acc = reciver_acc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MoneyTransfer [amount=" + amount + ", sender_acc=" + sender_acc + ", reciver_acc=" + reciver_acc
				+ ", date=" + date + "]";
	}

	
    
    
  
  

}
