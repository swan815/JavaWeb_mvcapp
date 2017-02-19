package com.lsy.mvcapp.domain;

public class Customer {
	
	private Integer id;
	
	private String name;
	
	private String Address;
	
	private String Phone;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
	

	public Customer() {
		super();
	}

	public Customer(String name, String address, String phone) {
		super();
		this.name = name;
		Address = address;
		Phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", Address=" + Address + ", Phone=" + Phone + "]";
	}
	

}
