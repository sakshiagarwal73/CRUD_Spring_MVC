package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

//We use @Repository for component scanning of DAO
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory; // same name as used in the configuration file while setting up SessionFactory;
    //@Autowired is used for Dependency Injection of sessionFactory
	
	@Override
	
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by firstName",Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer cust)
	{
		Session session = sessionFactory.getCurrentSession();
		
		//can save or update
		session.saveOrUpdate(cust);
	}
	
	@Override
	public Customer getCustomer(int id)
	{
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//retrieve the customer using the primary key
		Customer cust = session.get(Customer.class,id);
		
		return cust;
	}
	
	@Override
	public void deleteCustomer(int custid)
	{
		Session session = sessionFactory.getCurrentSession();
		
		Query thequery = session.createQuery("delete from Customer where id =:customerId");
		thequery.setParameter("customerId",custid); //parameter setting
		thequery.executeUpdate();
	}

}
