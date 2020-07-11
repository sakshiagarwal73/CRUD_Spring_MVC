package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;    

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		
		List<Customer> customerlist =  customerDAO.getCustomers();
		return customerlist;
	}
	
	//Now our service layer will define the transactions, so we add @Transactional in the service layer and remove it from DAO
	
	@Transactional
	@Override
    public void saveCustomer(Customer cust)
    {
    	customerDAO.saveCustomer(cust);
    }
	
	@Transactional
	@Override
	public Customer getCustomer(int id)
	{
	   return customerDAO.getCustomer(id);
	}
	
	
	@Transactional
	@Override
	public void deleteCustomer(int id)
	{
		 customerDAO.deleteCustomer(id);
	}
}
