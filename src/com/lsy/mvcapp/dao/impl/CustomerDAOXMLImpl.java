package com.lsy.mvcapp.dao.impl;

import java.util.List;

import com.lsy.mvcapp.dao.CriteriaCustomer;
import com.lsy.mvcapp.dao.CustomerDAO;
import com.lsy.mvcapp.domain.Customer;

public class CustomerDAOXMLImpl implements CustomerDAO {

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		System.out.println("getForListWithCriteriaCustomer");
		return null;
	}

	@Override
	public List<Customer> getAll() {
		System.out.println("getAll");
		return null;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("save");

	}

	@Override
	public Customer get(Integer id) {
		System.out.println("get");
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getCount(String name) {
		System.out.println("getCount");
		return 0;
	}

	@Override
	public void update(Customer customer) {
		System.out.println("update");

	}

}
