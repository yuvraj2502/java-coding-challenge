package com.model;

public class Policy {
	private int policyId;
    private String name;
    private double premium;
    private double rateOfInterest;
    
	public Policy(int policyId, String name, double premium, double rateOfInterest) {
		super();
		this.policyId = policyId;
		this.name = name;
		this.premium = premium;
		this.rateOfInterest = rateOfInterest;
	}

	public Policy() {
		super();
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", name=" + name + ", premium=" + premium + ", rateOfInterest="
				+ rateOfInterest + "]";
	}
	
    
}
