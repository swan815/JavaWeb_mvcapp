package com.lsy.mvcapp.dao;

public class CriteriaCustomer {
	
	private String name;
	
	private String phone;
	
	private String address;
	
	public String getName() {
		if(name==null)
			name="%%";
		else
			name="%"+name+"%";
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		if(phone==null)
			phone="%%";
		else
			phone="%"+phone+"%";
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		if(address==null)
			address="%%";
		else
			address="%"+address+"%";
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public CriteriaCustomer(String name, String phone, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	

}
