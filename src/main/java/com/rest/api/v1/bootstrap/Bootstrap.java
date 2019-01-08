package com.rest.api.v1.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rest.api.v1.domains.Category;
import com.rest.api.v1.domains.Customer;
import com.rest.api.v1.repositories.CategoryRepository;
import com.rest.api.v1.repositories.CustomerRepository;

@Component
public class Bootstrap implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		// adding dummy categories
		String[] categories = new String[] {"Fruits", "Dried", "Fresh", "Exotic", "Nuts"};
		for (String cat : categories) {
			Category category = new Category();
			category.setName(cat);
			categoryRepository.save(category);
		}
		System.out.println("Categories Loaded : " + categoryRepository.count());
		
		// adding dummy customers
		Customer c1 = new Customer();
		c1.setFirstName("Roberto");
		c1.setLastName("Firmino");
		customerRepository.save(c1);
		Customer c2 = new Customer();
		c2.setFirstName("Sadio");
		c2.setLastName("Mane");
		customerRepository.save(c2);
	}
}
