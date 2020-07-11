package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
	//We need to inject DAO into controller
	
	@Autowired
	private CustomerService customerService;
	
	  
	
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		//get customers from service
		List<Customer> customerlist = customerService.getCustomers();
		
		//add customers to Spring MVC model
		model.addAttribute("customers",customerlist);
		
		return "list-customers";
	}
	
	//We add a new customer to model and then in customer-form , using <form:input path = ""/> ,getter and setter methods are used.
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		Customer cust = new Customer();
		model.addAttribute("customer",cust);
		return "customer-form";
	}
	
	//@ModelAttribute is used when a new customer is added to the model and now after taking the details, we want to store in sql.
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer cust)
	{
	    customerService.saveCustomer(cust);
		return "redirect:/customer/list";
	}
	
	// We use @RequestParam because we are receiving the customer id of student which has to be updated
	//This customer id(customerId) is mentioned in list-customers, where along with the updateLink we have the primary key param.
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id,Model model)
	{
		//get the customer from the service
		Customer cust = customerService.getCustomer(id);
		
		//add customer to the model so that we can pre populate the form
		model.addAttribute("customer",cust);
		
		return "customer-form";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") int id)
	{
		customerService.deleteCustomer(id);
		
		
		//after deleting we, redirect to the same page to get list of names
		return "redirect:/customer/list";
	}
	
}
