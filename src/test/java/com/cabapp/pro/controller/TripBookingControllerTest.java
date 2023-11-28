package com.cabapp.pro.controller;
import com.cabapp.pro.dto.CabCurrentBookingResponseDTO;
import com.cabapp.pro.dto.CabResponseDTO;
import com.cabapp.pro.dto.TripBookingEndTripCustomerResponseDTO;
import com.cabapp.pro.dto.TripBookingRequestSubmitDTO;
import com.cabapp.pro.dto.TripBookingResponseDTO;
import com.cabapp.pro.entity.Cab;
import com.cabapp.pro.entity.TripBooking;
import com.cabapp.pro.service.ICustomerService;
import com.cabapp.pro.service.ITripBookingService;
import com.cabapp.pro.util.CabDTOMapper;
import com.cabapp.pro.util.TripBookingDTOMapper;
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
class TripBookingControllerTest {
 
    @Mock
    private ICustomerService customerService;
 
    @Mock
    private ITripBookingService tripService;
 
    @InjectMocks
    private CustomerController customerController;
 
    @Test
    void searchCabBasedOnLocationsTest() {
        String currentLocation = "TestLocation";
        List<Cab> mockCabs = new ArrayList<>(); // Mocking list of Cabs
        when(customerService.getCabByLocations(anyString())).thenReturn(mockCabs);
 
        ResponseEntity<List<CabCurrentBookingResponseDTO>> responseEntity = customerController.searchCabBasedOnLocations(currentLocation);
 
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        // Add more assertions based on the response entity
    }
 
  

 
    @Test
    void getAllTripBookingTest() {
        String custId = "1"; // Define a test customer ID
        List<TripBooking> mockTripBookings = new ArrayList<>(); // Mocking list of TripBooking
        when(tripService.viewAllTripsCustomer(anyString())).thenReturn(mockTripBookings);
 
        ResponseEntity<List<TripBookingEndTripCustomerResponseDTO>> responseEntity = customerController.getAllTripBooking(custId);
 
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add more assertions based on the response entity
    }
 
    @Test
    void updateBookingTest() {
        TripBooking mockTripBooking = new TripBooking(0, 0, null, null, null, null, false, 0, 0, null, null); // Mocking TripBooking
        when(tripService.updateTripBooking(any())).thenReturn(mockTripBooking);
 
        TripBooking updatedBooking = customerController.updateBooking(mockTripBooking);
 
        assertNotNull(updatedBooking);
        // Add more assertions based on the updated TripBooking
    }
 
    @Test
    void cancelBookingTest() {
        int tripId = 1; // Define a test trip ID
        TripBooking mockTripBooking = new TripBooking(0, tripId, null, null, null, null, false, tripId, tripId, null, null); // Mocking TripBooking
        when(tripService.deleteTripBooking(anyInt())).thenReturn(mockTripBooking);
 
        TripBooking canceledBooking = customerController.cancelBooking(tripId);
 
        assertNotNull(canceledBooking);
        // Add more assertions based on the canceled TripBooking
    }
    // Add more tests for other methods as needed...
}