package com.customer_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/updateForm")
	public String updateCustomerForm(@RequestParam("customerId") int id, 
			Model model) {
		
		// get the customer from database
		Customer customer = this.customerService.getCustomer(id);
		
		// set customer as model attribute
		model.addAttribute("customer", customer);
		
		// send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		// delete customer
		this.customerService.deleteCustomer(id);
		
		// send over to our form
		return "redirect:/customer/list";
	}
	
	@GetMapping("/addForm")
	public String addCustomerForm(Model model) {
		// create customer object
		Customer customer = new Customer();
		
		// add object to model
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		
		// save customer to session
		this.customerService.addCustomer(customer);
		
		// return list-customer.jsp
		return "redirect:/customer/list";
	}
}
