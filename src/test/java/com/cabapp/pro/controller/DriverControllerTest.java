package com.cabapp.pro.controller;
 
import com.cabapp.pro.dto.DriverRequestSubmitDTO;
import com.cabapp.pro.dto.TripBookingResponseByBookingDTO;
import com.cabapp.pro.entity.Driver;
import com.cabapp.pro.entity.Review;
import com.cabapp.pro.entity.TripBooking;
import com.cabapp.pro.exception.DriverException;
import com.cabapp.pro.service.IDriverService;
import com.cabapp.pro.util.DriverDTOMapper;
import com.cabapp.pro.util.TripBookingDTOMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
 
import java.util.List;
 
@ExtendWith(MockitoExtension.class)
class DriverControllerTest {
 
    @Mock
    private IDriverService driverService;
 
    @InjectMocks
    private DriverController driverController;
 
    @Test
    void saveDriverInfoTest() {
        DriverRequestSubmitDTO driverRequestSubmitDTO = new DriverRequestSubmitDTO(null, null, null, null, null, null, null); // Create test DTO
        Driver mockDriver = new Driver(null, null, null, null, null, 0, null, null, null, null, null, null, null, null); // Mocking Driver
        when(driverService.InsertDriver(any())).thenReturn(mockDriver);
 
        ResponseEntity<Object> responseEntity = driverController.saveDriverInfo(driverRequestSubmitDTO);
 
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Add more assertions based on the response entity
    }
 
 
   
    // Add more tests for other methods as needed...
}