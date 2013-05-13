package com.app.filterforget.domain;

import java.util.Date;

public class CreditCard {
	int cardNumber;
	Date expDate;

	public CreditCard(int cardNumber, Date expDate) {
		this.cardNumber = cardNumber;
		this.expDate = expDate;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

}
