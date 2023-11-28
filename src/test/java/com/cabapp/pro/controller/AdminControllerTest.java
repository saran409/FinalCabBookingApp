package com.cabapp.pro.controller;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
import com.cabapp.pro.dto.AdminRequestDTO;
import com.cabapp.pro.dto.AdminResponseDTO;
import com.cabapp.pro.dto.CabRequestDTO;
import com.cabapp.pro.dto.CabResponseDTO;
import com.cabapp.pro.dto.CustomerResponseDTO;
import com.cabapp.pro.dto.TripBookingResponseByCurrentBookingDTO;
import com.cabapp.pro.dto.TripBookingResponseDTO;
import com.cabapp.pro.entity.Admin;
import com.cabapp.pro.entity.Cab;
import com.cabapp.pro.entity.Customer;
import com.cabapp.pro.entity.TripBooking;
import com.cabapp.pro.service.IAdminService;
import com.cabapp.pro.service.ICabService;
import com.cabapp.pro.service.IComplaintService;
import com.cabapp.pro.service.ICustomerService;
import com.cabapp.pro.service.IDriverService;
import com.cabapp.pro.service.ITripBookingService;
import com.cabapp.pro.util.TripBookingDTOMapper;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
 
    @ExtendWith(MockitoExtension.class)
    class AdminControllerTest {
 
        @Mock
        private IAdminService adminService;
 
        @Mock
        private IDriverService driverService;
 
        @Mock
        private ITripBookingService tripBooking;
 
        @Mock
        private ICabService cabService;
        
        @Mock
        private ICustomerService customerService;
 
        @Mock
        private IComplaintService complaintService;
 
        @InjectMocks
        private AdminController adminController;
 
        @Test
        void saveAdminTest() {
            AdminRequestDTO adminRequestDTO = new AdminRequestDTO(null, null, null, null, null, 0); // Create test DTO
            Admin mockAdmin = new Admin(null,null, null, null, null, 0); // Mocking Admin
            when(adminService.insertAdmin(any())).thenReturn(mockAdmin);
 
            ResponseEntity<AdminResponseDTO> responseEntity = adminController.saveAdmin(adminRequestDTO);
 
            assertNotNull(responseEntity);
            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            // Add more assertions based on the response entity
        }
 
        @Test
        void updateAdminTest() {
            AdminRequestDTO adminRequestDTO = new AdminRequestDTO(null, null, null, null, null, 0); // Create test DTO
            Admin mockAdmin = new Admin(null,null, null, null, null, 0); // Mocking Admin
            when(adminService.updateAdmin(any())).thenReturn(mockAdmin);
 
            ResponseEntity<AdminResponseDTO> responseEntity = adminController.updateAdmin(adminRequestDTO);
 
            assertNotNull(responseEntity);
            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            // Add more assertions based on the response entity
        }
        @Test
        void getAllCustomersTest() {
            List<Customer> customers = new ArrayList<>(); // Create test list of Customers
            when(customerService.viewCustomers()).thenReturn(customers);

            ResponseEntity<List<CustomerResponseDTO>> responseEntity = adminController.getAllCustomers();

            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            assertNotNull(responseEntity.getBody());
            // Add more assertions based on the response entity
        }
        @Test
        void getAllTripBookingsTest() {
            int customerId = 1; // Define a test customer ID
            List<TripBooking> mockTripBookings = new ArrayList<>(); // Mocking list of TripBookings
            when(tripBooking.getAllTrips(anyInt())).thenReturn(mockTripBookings);
 
            ResponseEntity<List<TripBookingResponseDTO>> responseEntity = adminController.getAllTripBookings(customerId);
 
            assertNotNull(responseEntity);
            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            // Add more assertions based on the response entity
        }
        // Add more tests for other methods as needed...

 
    

    @Test
    void getTripByCustomerOrderTest() {
        List<TripBooking> trips = new ArrayList<>(); // Create test list of TripBookings
        when(adminService.getTripsCustomerwise()).thenReturn(trips);
 
        ResponseEntity<List<TripBookingResponseDTO>> responseEntity = adminController.getTripByCustomerOrder();
        List<TripBookingResponseDTO> tripBookingResponseDTOList = responseEntity.getBody();
 
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(tripBookingResponseDTOList);
        // Add more assertions based on your DTOs and expected results
    }
 
    @Test
    void getTripByCabwiseTest() {
        Map<Integer, List<TripBooking>> trips = new HashMap<>(); // Define a test map for TripBookings
        when(adminService.getTripsCabwise()).thenReturn(trips);
 
        ResponseEntity<Map<Integer, List<TripBooking>>> responseEntity = adminController.getTripByCabwise();
 
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        // Add more assertions based on your expected results
    }
 
    @Test
    void getTripByDateOrderTest() {
        List<TripBooking> trips = new ArrayList<>(); // Create test list of TripBookings
        when(adminService.getTripsDatewise()).thenReturn(trips);
 
        ResponseEntity<List<TripBooking>> responseEntity = adminController.getTripByDateOrder();
 
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        // Add more assertions based on your expected results
    }
 
     
 
  
    }