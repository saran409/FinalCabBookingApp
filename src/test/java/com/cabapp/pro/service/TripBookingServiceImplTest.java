package com.cabapp.pro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cabapp.pro.entity.TripBooking;
import com.cabapp.pro.repository.ITripBookingRepository;
import com.cabapp.pro.service.TripBookingServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TripBookingServiceImplTest {

    @Mock
    private ITripBookingRepository mockTripBookingRepository;

    @InjectMocks
    private TripBookingServiceImpl tripBookingService;

//    @Test
//    void testViewAllTripsCustomer() {
//      
//        int customerId = 123;
//        TripBooking trip1 = new TripBooking(0,0,null, null, null, null, false, customerId, customerId, null, null);
//        TripBooking trip2 = new TripBooking(0, customerId, null, null, null, null, false, customerId, customerId, null, null);
//        List<TripBooking> mockTrips = new ArrayList<>();
//        mockTrips.add(trip1);
//        mockTrips.add(trip2);
//̥
//        
//        when(mockTripBookingRepository.findAll()).thenReturn(mockTrips);
//
//       
//        List<TripBooking> result = tripBookingService.viewAllTripsCustomer(customerId);
//
//        
//        List<TripBooking> expected = mockTrips.stream()
//                .filter(trip -> trip.getCustomerId() == customerId)
//                .collect(Collectors.toList());
//
//      
//        assertEquals(expected, result);
//    }
    @Test
    public void testDeleteTripBooking() {
       
        Mockito.when(mockTripBookingRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new TripBooking()));

        
        TripBooking result = tripBookingService.deleteTripBooking(1); // Assuming ID 1 for testing

      
        Assertions.assertNull(result); 
    }

    
}

