package com.cabapp.pro.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
public class Driver extends AbstractUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	private String licenseNo;
	private String status;
	private Boolean available;
	private String currentLocation;
	private Double avgRating;
 

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cab_Id")
	private Cab cab;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Dri_Id")
	private List<TripBooking> tripbookings;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "driver_id")
	private List<Review> reviews;

	public Driver(String username, String password, String address, String mobileNumber, String email, int driverId,
			String licenseNo, String status, Boolean available, String currentLocation, Double avgRating, Cab cab,
			List<TripBooking> tripbookings, List<Review> reviews) {
		super(username, password, address, mobileNumber, email);
		this.driverId = driverId;
		this.licenseNo = licenseNo;
		this.status = status;
		this.available = available;
		this.currentLocation = currentLocation;
		this.avgRating = avgRating;
		this.cab = cab;
		this.tripbookings = tripbookings;
		this.reviews = reviews;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(String username, String password, String address, String mobileNumber, String email) {
		super(username, password, address, mobileNumber, email);
		// TODO Auto-generated constructor stub
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public List<TripBooking> getTripbookings() {
		return tripbookings;
	}

	public void setTripbookings(List<TripBooking> tripbookings) {
		this.tripbookings = tripbookings;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(available, avgRating, cab, currentLocation, driverId, licenseNo, reviews,
				status, tripbookings);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return Objects.equals(available, other.available) && Objects.equals(avgRating, other.avgRating)
				&& Objects.equals(cab, other.cab) && Objects.equals(currentLocation, other.currentLocation)
				&& driverId == other.driverId && Objects.equals(licenseNo, other.licenseNo)
				&& Objects.equals(reviews, other.reviews) && Objects.equals(status, other.status)
				&& Objects.equals(tripbookings, other.tripbookings);
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenseNo=" + licenseNo + ", status=" + status + ", available="
				+ available + ", currentLocation=" + currentLocation + ", avgRating=" + avgRating + ", cab=" + cab
				+ ", tripbookings=" + tripbookings + ", reviews=" + reviews + "]";
	}


	


	
}
