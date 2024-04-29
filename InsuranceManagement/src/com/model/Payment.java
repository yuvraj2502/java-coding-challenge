package com.model;

public class Payment {
    private int paymentId;
    private String date;
    private double amount;
    private int clientId;

	public Payment() {
		
	}

	public Payment(int paymentId, String date, double amount, int clientId) {
		super();
		this.paymentId = paymentId;
		this.date = date;
		this.amount = amount;
		this.clientId = clientId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

    
}
