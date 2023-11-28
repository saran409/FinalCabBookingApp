package com.cabapp.pro.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;



@Component
public class TripBookingRequestSubmitDTO {
	
	@NotNull(message = "Customer ID cannot be null")
    private int customerId;
 
    @NotBlank(message = "From location cannot be blank")
    private String fromLocation;
 
    @NotBlank(message = "To location cannot be blank")
    private String toLocation;
 
    @FutureOrPresent(message = "From date and time must be in the present or future")
    private LocalDateTime fromDateTime;
 
     
    
    private float distanceInKm;
 
	public TripBookingRequestSubmitDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TripBookingRequestSubmitDTO(int customerId, String fromLocation, String toLocation,
			LocalDateTime fromDateTime,    float distanceInKm ) {
		super();
		this.customerId = customerId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
	
		
		this.distanceInKm = distanceInKm;
		
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	
	
	public float getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	@Override
	public String toString() {
		return "TripBookingRequestSubmitDTO [customerId=" + customerId + ", fromLocation=" + fromLocation
				+ ", toLocation=" + toLocation + ", fromDateTime=" + fromDateTime + ", distanceInKm=" + distanceInKm
				+ "]";
	}
	
	

}
