package com.app.spring.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.spring.example.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
