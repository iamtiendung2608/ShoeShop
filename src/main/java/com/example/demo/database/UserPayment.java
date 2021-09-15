package com.example.demo.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class UserPayment {
	@Id
	@Size(min=15,message="Credit card number must have more than 15 digits")
	private String CardNumber;
	@Max(value=12,message="You must type valid date")
	private String MonthRelease;
	@Max(value=2020,message="Your card must have more than 1 year used since 2021")
	private String YearRelease;
	@Min(value=3,message="Security Code must have more than 3 digits")
	private String SecurityCode;
	@Size(min=8,message="Phone number must have more than 8 digits")
	private String PhoneNumber;
	public UserPayment(String cardNumber, String dateRelease, String yearRelease, String securityCode,
			String phoneNumber) {
		CardNumber = cardNumber;
		MonthRelease = dateRelease;
		YearRelease = yearRelease;
		SecurityCode = securityCode;
		PhoneNumber = phoneNumber;
	}
	public UserPayment() {
		
	}
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}
	
	public String getYearRelease() {
		return YearRelease;
	}
	public void setYearRelease(String yearRelease) {
		YearRelease = yearRelease;
	}
	public String getSecurityCode() {
		return SecurityCode;
	}
	public void setSecurityCode(String securityCode) {
		SecurityCode = securityCode;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getMonthRelease() {
		return MonthRelease;
	}
	public void setMonthRelease(String monthRelease) {
		MonthRelease = monthRelease;
	}
	@Override
	public String toString() {
		return "UserPayment [CardNumber=" + CardNumber + ", MonthRelease=" + MonthRelease + ", YearRelease="
				+ YearRelease + ", SecurityCode=" + SecurityCode + ", PhoneNumber=" + PhoneNumber + "]";
	}
}
