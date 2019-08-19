package com.customer_tracker.dao;

import java.util.List;

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
		return null;
	}

}
