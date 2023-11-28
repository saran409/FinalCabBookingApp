package com.cabapp.pro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
 
import com.cabapp.pro.entity.Customer;
import com.cabapp.pro.repository.ICustomerRepository;
import com.cabapp.pro.service.CustomerServiceImpl;
 
@SpringBootTest
class CustomerServiceImplTest {
	@MockBean
	ICustomerRepository mockCustomerRepository ;
	@Autowired
	CustomerServiceImpl customerService;
	@Test
	void testInsertCustomer() {
		Customer actualOutput = new Customer(0, null);
		Customer customer = new Customer(0,null);
		
		when(mockCustomerRepository.save(customer)).thenReturn(actualOutput);
		
		assertEquals(actualOutput, customerService.insertCustomer(customer));
	}
	@Test
	void testViewCustomer() {
		Customer actualOutput = new Customer(0, null);
		Customer c = new Customer(0, null);
		
		Customer output = c;
		when(mockCustomerRepository.getCustomerByCustomerId(1)).thenReturn(output);
		
		assertEquals(actualOutput, customerService.viewCustomer(1));
	}
 
}
