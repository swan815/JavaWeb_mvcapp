package com.lsy.mvcapp.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lsy.mvcapp.dao.CriteriaCustomer;
import com.lsy.mvcapp.dao.CustomerDAO;
import com.lsy.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import com.lsy.mvcapp.domain.Customer;

public class CustomerDAOJdbcImplTest {
	
	private CustomerDAO customerDAO=new CustomerDAOJdbcImpl();

	@Test
	public void testGetAll() {
		List<Customer> customers=customerDAO.getAll();
		System.out.println(customers);
	}

	@Test
	public void testSaveCustomer() {
		Customer cust=new Customer();
		cust.setAddress("ShangHai");
		cust.setName("Jerry");
		cust.setPhone("17862706273");
		
		customerDAO.save(cust);
	}

	@Test
	public void testGetInteger() {
		Customer cust = customerDAO.get(1);
		System.out.println(cust);
	}

	@Test
	public void testDelete() {
		customerDAO.delete(1);
	}

	@Test
	public void testGetCount() {
		long count = customerDAO.getCount("Jerry");
		System.out.println(count);
	}
	@Test
	public void testGetForListWithCriteriaCustomer(){
		CriteriaCustomer cc = new CriteriaCustomer("w", null, null);
		List<Customer> customers=customerDAO.getForListWithCriteriaCustomer(cc);
		System.out.println(customers);
	}

}
