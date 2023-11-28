package com.cabapp.pro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cabapp.pro.entity.TripBooking;

@Service
public interface ITripBookingService {
	
	
	
	public TripBooking insertTripBooking(TripBooking tripBooking);
	public List<TripBooking> viewAllTripsCustomer(String customerName);
	public TripBooking updateTripBooking(TripBooking tripBooking);
	public TripBooking deleteTripBooking(int tripBookingId);
	public List<TripBooking> getAllTrips(int customerId);
	public void addReviewToTrip(int tripBookingId);
	

}
