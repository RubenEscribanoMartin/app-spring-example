package com.app.spring.example.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String productName;
	private String productReferenceNumber;
	
	@ManyToMany
	@JoinTable(name= "user_product", joinColumns = @JoinColumn(name ="product_id"), 
		inverseJoinColumns = @JoinColumn(name= "user_id"))
	
	private Set<User> users = new HashSet<>();

	public Product(String productName, String productReferenceNumber) {
		this.productName = productName;
		this.productReferenceNumber = productReferenceNumber;
	}

	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductReferenceNumber() {
		return productReferenceNumber;
	}

	public void setProductReferenceNumber(String productReferenceNumber) {
		this.productReferenceNumber = productReferenceNumber;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productReferenceNumber="
				+ productReferenceNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	



}
