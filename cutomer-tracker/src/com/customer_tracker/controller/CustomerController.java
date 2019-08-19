package com.customer_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer_tracker.dao.CustomerDOA;
import com.customer_tracker.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDOA customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		// get customers from dao
		List<Customer> customers = this.customerDAO.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
