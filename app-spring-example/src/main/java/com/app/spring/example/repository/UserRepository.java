package com.app.spring.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.spring.example.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
