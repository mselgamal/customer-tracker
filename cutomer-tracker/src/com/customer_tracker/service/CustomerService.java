package com.customer_tracker.service;

import java.util.List;

import com.customer_tracker.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	public void addCustomer(Customer customer);
	public void deleteCustomer(int id);
	public Customer getCustomer(int id);
}
