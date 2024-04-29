package com.model;

public class Client {
    private int clientId;
    private String name;
    private String contactInfo;
    private int policyId;
    private int userId;

	public Client(int clientId, String name, String contactInfo, int policyId, int userId) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.contactInfo = contactInfo;
		this.policyId = policyId;
		this.userId = userId;
	}

	public Client() {
		super();
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
