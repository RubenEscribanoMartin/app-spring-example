package com.app.spring.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.spring.example.repository.ProductRepository;

@Controller
public class ProductController {
	
	private ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@RequestMapping("/products")
	public String getProducts(Model model) {
		
		model.addAttribute("products", productRepository.findAll());
		
		return "productList";
	}
	
	

}
