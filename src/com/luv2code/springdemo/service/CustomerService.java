package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();
	
	public void saveCustomer(Customer cust);

	Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
