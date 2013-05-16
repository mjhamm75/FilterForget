package com.app.filterforget.domain;

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

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getMaskedNumber() {
		int length = cardNumber.length();
		String lastFour = cardNumber.substring(length - 4, length);
		StringBuffer maskedNumber = new StringBuffer();
		for (int i = 0; i < length - 4; i++) {
			maskedNumber.append("*");
		}
		maskedNumber.append(lastFour);
		return maskedNumber.toString();
	}
}
