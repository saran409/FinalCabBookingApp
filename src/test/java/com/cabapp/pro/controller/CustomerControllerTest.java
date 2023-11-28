
package com.cabapp.pro.controller;

import com.cabapp.pro.dto.CustomerRequestSubmitDTO;
import com.cabapp.pro.dto.CustomerResponseDTO;
import com.cabapp.pro.entity.Customer;
import com.cabapp.pro.service.ICustomerService;
import com.cabapp.pro.util.CustomerDTOMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

   @Mock
   private ICustomerService service;

   @InjectMocks
   private CustomerController customerController;
   
   

   @Test
   void saveCustomerTest() {
       CustomerRequestSubmitDTO requestDTO = new CustomerRequestSubmitDTO(null, null, null, null, null); // Create test DTO
       Customer customer = new Customer(0, null); // Create test Customer
       when(service.insertCustomer(any())).thenReturn(customer);

       ResponseEntity<CustomerResponseDTO> responseDTO = customerController.saveCustomer(requestDTO);

       assertNotNull(responseDTO);
       // Add more assertions based on the response DTO
   }

   @Test
   void getCustomerByIdTest() {
       int customerId = 1; // Define a test customer ID
       Customer customer = new Customer(0, null); // Create test Customer
       when(service.viewCustomer(anyInt())).thenReturn(customer);

       ResponseEntity<CustomerResponseDTO> responseDTO = customerController.getCustomerById(customerId);

       assertNotNull(responseDTO);
       // Add more assertions based on the response DTO
   }

    

    

   @Test
   void updateCustomerTest() {
       int customerId = 1; // Define a test customer ID
       Customer customer = new Customer(customerId, null); // Create test Customer
       when(service.updateCustomer(any(), anyInt())).thenReturn(customer);

       Customer responseDTO = service.updateCustomer(customer, customerId);

       assertNotNull(responseDTO);
       // Add more assertions based on the response DTO
   }

   @Test
   void deleteCustomerByIdTest() {
       int customerId = 1; // Define a test customer ID
       Customer customer = new Customer(0, null); // Create test Customer
       when(service.deleteCustomer(anyInt())).thenReturn(customer);

       CustomerResponseDTO responseDTO = customerController.deleteCustomerById(customerId);

       assertNotNull(responseDTO);
       // Add more assertions based on the response DTO
   }
   // Add more tests for other methods as needed...
}