package com.cabapp.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cabapp.pro.entity.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Customer getCustomerByCustomerId(int customerId);

	@Query(value="select * from customer where username=:username",nativeQuery=true)
	public Customer findByUsername(String username);

}
