package com.ra2.Aav1.controller;

import com.ra2.Aav1.repository.CustomerRepository;
import com.ra2.Aav1.model.Customer;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/jdbctemplate")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRep;
	
	@PostMapping("/initDB")
	public String create_insertDB() {
		customerRep.createTableCustomers();
		customerRep.insertSampleData();
		return "taula creada correctament i dades inserides";
	}
	
	@GetMapping("/findAllCustomers")
	public List<Customer> getAllCustomers() {
		return customerRep.findAll();
	}
}