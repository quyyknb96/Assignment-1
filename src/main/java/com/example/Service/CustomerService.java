package com.example.Service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.inter.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void run() {
		log.error("=======================================");
		log.error("Table Customer");
		customerRepository.deleteAllInBatch();
		Customer customer1 = new Customer("Nguyen Van", "A", "0123456789", "030842123", "default@gmail.com", "a");
		Customer customer2 = new Customer("Doan Van", "B", "0123987456", "030789456", "demo@gmail.com", "b");
		Customer customer3 = new Customer("Ta Quang", "C", "0321654789", "030842178", "test@gmail.com", "c");
		ArrayList<Customer> list_Customer = new ArrayList<>();
		list_Customer.add(customer1);
		list_Customer.add(customer2);
		list_Customer.add(customer3);
		//Insert
		customerRepository.save(list_Customer);
		log.error("Insert OK");
		//Update
		Customer customer = customerRepository.findByCustomerId(3);
		customer.setCustomerFirstName("Ta Ngoc");
		customerRepository.save(customer);
		log.error("Update OK");
		//Select
		customerRepository.findByCustomerId(2);
		log.error("Select OK");
		//Delete
		customerRepository.delete(2);
		log.error("Delete OK");
		log.error("=======================================");
	}
}
