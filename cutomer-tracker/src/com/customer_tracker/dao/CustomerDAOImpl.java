package com.customer_tracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer_tracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDOA {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get hibernate session
		Session session = this.sessionFactory.getCurrentSession();
		
		// write query, execute and get results
		List<Customer> customers = session.createQuery("from Customer", 
				Customer.class).getResultList();
		
		// return results
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {
		// get current session
		Session session = this.sessionFactory.getCurrentSession();
		
		// save object to session
		session.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
	}

	@Override
	public void deleteCustomer(Customer customer) {
	}

}
