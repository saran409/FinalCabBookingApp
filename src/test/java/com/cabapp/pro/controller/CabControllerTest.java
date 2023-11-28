package com.cabapp.pro.controller;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cabapp.pro.service.IAdminService;
import com.cabapp.pro.service.ICabService;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
@ExtendWith(MockitoExtension.class)
class CabControllerTest {
 
    @Mock
    private ICabService cabService;
 
    @InjectMocks
    private AdminController adminController;
    @Mock
    private IAdminService adminService;
 
    @Test
    void deleteCabTest() {
        int cabId = 1; // Define a test cab ID
 
        // Mocking the behavior of cabService.deleteCab
        when(cabService.deleteCab(eq(cabId))).thenReturn("Cab deleted successfully");
 
        ResponseEntity<String> responseEntity = adminController.deleteCab(cabId);
        String message = responseEntity.getBody();
 
        // Assertions or verifications based on the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(message);
        assertEquals("Cab deleted successfully", message);
        // Add more assertions based on your expected results
    }
}