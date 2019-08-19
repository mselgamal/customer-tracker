package com.customer_tracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer_tracker.dao.CustomerDOA;
import com.customer_tracker.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDOA customerDOA;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return this.customerDOA.getCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		this.customerDOA.addCustomer(customer);
	}
}
