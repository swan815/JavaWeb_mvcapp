package com.lsy.mvcapp.dao;

import java.util.List;

import com.lsy.mvcapp.domain.Customer;

public interface CustomerDAO {
	
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	
	public List<Customer>  getAll();
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	public long getCount(String name);
	
	public void update(Customer customer);

}
