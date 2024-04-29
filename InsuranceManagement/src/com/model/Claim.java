package com.model;

public class Claim {
    private int claimId;
    private int claimNum;
    private String dateFiled;
    private double amount;
    private String status;
    private int policyId;
    private int clientId;
	
	public Claim(int claimId, int claimNum, String dateFiled, double amount, String status, int policyId,
			int clientId) {
		super();
		this.claimId = claimId;
		this.claimNum = claimNum;
		this.dateFiled = dateFiled;
		this.amount = amount;
		this.status = status;
		this.policyId = policyId;
		this.clientId = clientId;
	}

	public Claim() {

	}
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public int getClaimNum() {
		return claimNum;
	}
	public void setClaimNum(int claimNum) {
		this.claimNum = claimNum;
	}
	public String getDateFiled() {
		return dateFiled;
	}
	public void setDateFiled(String dateFiled) {
		this.dateFiled = dateFiled;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
    
    
}
