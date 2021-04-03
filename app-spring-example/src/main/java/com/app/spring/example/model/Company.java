package com.app.spring.example.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String companyName;
	private String companyCountry;
	private String companyPhoneNumber;
	
	@OneToMany
	@JoinColumn(name= "company_id")
	private Set<Product> products = new HashSet<>();

	public Company() {
	}

	public Company(String companyName, String companyCountry, String companyPhoneNumber) {
		this.companyName = companyName;
		this.companyCountry = companyCountry;
		this.companyPhoneNumber = companyPhoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCountry() {
		return companyCountry;
	}

	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	public String getCompanyPhoneNumber() {
		return companyPhoneNumber;
	}

	public void setCompanyPhoneNumber(String companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", companyCountry=" + companyCountry
				+ ", companyPhoneNumber=" + companyPhoneNumber + "]";
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
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
