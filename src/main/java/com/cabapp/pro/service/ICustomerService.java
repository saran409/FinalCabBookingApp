package com.cabapp.pro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cabapp.pro.dto.LoginDto;
import com.cabapp.pro.entity.Cab;
import com.cabapp.pro.entity.Customer;
import com.cabapp.pro.entity.TripBooking;

@Service
public interface ICustomerService {
	
	
	public Customer insertCustomer(Customer customer);
	public Customer viewCustomer(int customerId);//getting customers based on userId not on cuatomerId problem
	public List<Customer> viewCustomers();
	public String checkCustomerByUserName(String userName);
	public Customer updateCustomer(Customer customer, int id );
	public Customer deleteCustomer(int customerId);
	public List<Cab> getCabByLocations(String currentLocation);
	public TripBooking getTripBookingByUserId(int userId);
	public Customer viewCustomerByCustomerName(String userId);


}
