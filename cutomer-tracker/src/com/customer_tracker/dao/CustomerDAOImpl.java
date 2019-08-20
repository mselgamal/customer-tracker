package com.customer_tracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		List<Customer> customers = session.createQuery("from Customer order by lastName", 
				Customer.class).getResultList();
		
		// return results
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {
		// get current session
		Session session = this.sessionFactory.getCurrentSession();
		
		// save or update customer
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// get current session
		Session session = this.sessionFactory.getCurrentSession();
		
		// get customer and return
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		// get current session
		Session session = this.sessionFactory.getCurrentSession();
		
		// delete customer
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", id);
		
		query.executeUpdate();
	}

}
