package com.app.spring.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.spring.example.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
