package com.app.filterforget.domain;

import java.util.List;

public class User {
	String firstName;
	String lastName;
	Address address;
	List<CreditCard> creditCards;

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
