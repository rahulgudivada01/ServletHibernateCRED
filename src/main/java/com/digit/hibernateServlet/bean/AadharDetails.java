package com.digit.hibernateServlet.bean;

public class AadharDetails {
	public String aadhar_id;
	public String name;
	public String email;
	public long number;
	public String address;
	public String city;
	public String state;
	public int pincode;
	public String getAadhar_id() {
		return aadhar_id;
	}
	public void setAadhar_id(String aadhar_id) {
		this.aadhar_id = aadhar_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public boolean getuser(String id)
	{
		if(id==aadhar_id)
			return true;
		else
			return false;
	}

}
