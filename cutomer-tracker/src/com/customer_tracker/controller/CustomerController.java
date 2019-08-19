package com.customer_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer_tracker.entity.Customer;
import com.customer_tracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		// get customers from dao
		List<Customer> customers = this.customerService.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/add/form")
	public String addCustomerForm(Model model) {
		// create customer object
		Customer customer = new Customer();
		
		// add object to model
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/add/customer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		
		// save customer to session
		this.customerService.addCustomer(customer);
		
		// return list-customer.jsp
		return "list-customers";
	}
}
