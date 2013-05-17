package com.app.filterforget.domain;

public class CreditCard {
	public int id;
	public String cardNumber;
	public String expDate;
	public String cvc;

	public CreditCard(String cardNumber, String expDate, String cvc) {
		this.cardNumber = cardNumber;
		this.expDate = expDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
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
