package com.app.spring.example.bootStrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.spring.example.model.Company;
import com.app.spring.example.model.Product;
import com.app.spring.example.model.User;
import com.app.spring.example.repository.CompanyRepository;
import com.app.spring.example.repository.ProductRepository;
import com.app.spring.example.repository.UserRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final CompanyRepository companyRepository;

	public BootStrapData(UserRepository userRepository, ProductRepository productRepository,
			CompanyRepository companyRepository) {
		this.userRepository = userRepository;
		this.productRepository = productRepository;
		this.companyRepository = companyRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Started in BootStrap");
		
		/*
		 * CreatingData Company
		 */
		Company companyA = new Company();
		companyA.setCompanyName("Basha&Co");
		companyA.setCompanyCountry("Italy");
		companyA.setCompanyPhoneNumber("+44899552200");
		//saving this company entity in the repository
		companyRepository.save(companyA);
		
		/*
		 * CreatingData User+Product
		 */
		User userA = new User("James", "+419955663322");
		Product productA = new Product("ToolBox", "FB-299100");
		//engaging both
		userA.getProducts().add(productA);
		productA.getUsers().add(userA);
		
		//engaging product and company
		productA.setCompany(companyA);
		companyA.getProducts().add(productA);
		
		/*
		 * Saving data in the repository
		 */
		userRepository.save(userA);
		productRepository.save(productA);
		companyRepository.save(companyA); //this one again due to engaging product
		/*
		 * So at this point we have three (3) object model created with data and
		 * their engages
		 */
		System.out.println("Amount of User/s - " + userRepository.count());
	}

}
