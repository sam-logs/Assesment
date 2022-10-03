package com.bhavna.service;

public class BuyingDetails {
	int customerId;
	int userId;
	String purchaseDate;
	String productName;

	public BuyingDetails(int customerId, int userId, String purchaseDate, String productName) {
		super();
		this.customerId = customerId;
		this.userId = userId;
		this.purchaseDate = purchaseDate;
		this.productName = productName;
	}

}
