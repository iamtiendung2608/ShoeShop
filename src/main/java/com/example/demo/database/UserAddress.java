package com.example.demo.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserAddress {
	@Id
	@NotNull
	@Size(min=1,message="Home number must be valid")
	public String Home_Number;
	@NotNull
	@Size(min=3,message="Country must be valid")
	public String Country;
	@NotNull
	@Size(min=3,message="Province must be valid")
	public String Province;
	@NotNull
	@Size(min=3,message="City must be valid")
	public String City;
	@NotNull
	@Size(min=3,message="Street must be valid")
	public String Street;
	public UserAddress(String Home_number, String country, String province, String city, String street) {
		Home_Number = Home_number;
		Country = country;
		Province = province;
		City = city;
		Street = street;
	}
	public String getHome_Number() {
		return Home_Number;
	}
	public void setHome_Number(String home_Number) {
		Home_Number = home_Number;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public UserAddress() {}
	@Override
	public String toString() {
		return "UserAddress [Home_Number=" + Home_Number + ", Country=" + Country + ", Province=" + Province + ", City="
				+ City + ", Street=" + Street + "]";
	}
}
