package com.app.filterforget.domain;

import java.util.Date;

public class CreditCard {
	String cardNumber;
	String expDate;

	public CreditCard(String cardNumber, String expDate) {
		this.cardNumber = cardNumber;
		this.expDate = expDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String  getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

}
