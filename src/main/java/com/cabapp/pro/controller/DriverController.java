package com.cabapp.pro.controller;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.cabapp.pro.dto.DriverBasicResponseDTO;
import com.cabapp.pro.dto.DriverRequestSubmitDTO;
import com.cabapp.pro.dto.TripBookingEndResponseDTO;
import com.cabapp.pro.dto.TripBookingResponseByBookingDTO;
import com.cabapp.pro.entity.Driver;
import com.cabapp.pro.entity.TripBooking;
import com.cabapp.pro.exception.DriverException;
import com.cabapp.pro.service.IComplaintService;
import com.cabapp.pro.service.IDriverService;
import com.cabapp.pro.util.DriverDTOMapper;
import com.cabapp.pro.util.TripBookingDTOMapper;
 
import io.swagger.annotations.Api;
 
@RestController
@RequestMapping("/driver")
@CrossOrigin("*")

@Validated
@Api
public class DriverController {
	
	@Autowired
	IDriverService driverService;

	@Autowired
	IComplaintService complaintService;

	/**
	 * POST endpoint for registering a new driver.
	 *
	 * @param dto The DriverRequestSubmitDTO containing the details for the new driver.
	 * @return ResponseEntity<Object> representing the HTTP response with the basic details of the registered driver,
	 *         or HttpStatus.NOT_FOUND if registration fails.
	 */
	@PostMapping("/register")
	public ResponseEntity<Object> saveDriverInfo(@Valid @RequestBody DriverRequestSubmitDTO dto) {

			DriverDTOMapper converter=new DriverDTOMapper();
			Driver driver= converter.getDriverFromDriverDTO(dto);
			return ResponseEntity.status(HttpStatus.OK).body(converter.getDriverBasicDTOFromDriver( driverService.InsertDriver(driver)));
		}
	
	@GetMapping("/driverDetails/{driverName}")
	public ResponseEntity<Object> fetchDriverDetails(@PathVariable String driverName) {
		 

			DriverDTOMapper converter=new DriverDTOMapper();
			return ResponseEntity.status(HttpStatus.OK).body(converter.getDriverBasicDTOFromDriver( driverService.fetchDriverByUserName(driverName)));
		}
	
	
//======================================================================================================================================================================================================================	
	/**
	 * GET endpoint for retrieving trip booking information for a specific customer based on their user ID.
	 *
	 * @param userId The ID of the customer for whom trip booking information is to be retrieved.
	 * @return ResponseEntity<TripBookingResponseByBookingDTO> representing the HTTP response with the trip booking information for the specified customer,
	 *         or a DriverException with HttpStatus.BAD_REQUEST if the user ID is null or empty.
	 */
	@GetMapping("/booking/{username}")//
	public ResponseEntity<TripBookingResponseByBookingDTO> getTripBookinginfo(@PathVariable String username) {
		if(!username.isEmpty()) {
		TripBookingDTOMapper converter=new TripBookingDTOMapper();
		TripBooking trip=driverService.getTripBookingByUser(username);
		TripBookingResponseByBookingDTO dto1=converter.getTripBookingDTOFromTripBookingByDriverId(trip);
		return new ResponseEntity<TripBookingResponseByBookingDTO>(dto1,HttpStatus.OK);
		}
		else {
		 throw new DriverException(400,"user id is null or emtpy");	
		}
	}
//======================================================================================================================================================================================================================	
	/**
	 * PUT endpoint for updating driver information based on the provided driver ID.
	 *
	 * @param driverId The ID of the driver to be updated.
	 * @param driver The Driver object containing the updated details.
	 * @return ResponseEntity<DriverBasicResponseDTO> representing the HTTP response with the basic details of the updated driver,
	 *         or HttpStatus.NOT_FOUND if the driver ID is not found.
	 */
	@PutMapping("/update/{driverId}")
    public ResponseEntity<DriverBasicResponseDTO> updateDriver(@PathVariable int driverId, @RequestBody Driver driver) {
		DriverDTOMapper converter=new DriverDTOMapper();
        Driver updatedDriver = driverService.updateDriver(driver, driverId);
        DriverBasicResponseDTO dto= converter.getDriverBasicDTOFromDriver(updatedDriver);
        if (dto != null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	//======================================================================================================================================================================================================================	
	/**
	 * PUT endpoint for ending a trip based on the provided trip ID.
	 *
	 * @param tripId The ID of the trip to be ended.
	 * @return ResponseEntity<Object> representing the HTTP response with the result of ending the trip.
	 */
	@PutMapping("/endTrip/{tripId}")
	public  ResponseEntity<TripBookingEndResponseDTO> endTrip(@PathVariable int tripId) {
		TripBookingDTOMapper converter=new TripBookingDTOMapper();
		TripBookingEndResponseDTO dto= converter.getTripBookingEndTripDTOFromTripBooking( driverService.tripEnd(tripId));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
//======================================================================================================================================================================================================================	
	/**
	 * GET endpoint for retrieving reviews for a specific driver based on the driver's ID.
	 *
	 * @param driverId The ID of the driver for whom reviews are to be retrieved.
	 * @return ResponseEntity<Object> representing the HTTP response with the reviews related to the specified driver.
	 */
	@GetMapping("/fetchReviews/{driverId}")
	public  ResponseEntity<Object> getReviews(@PathVariable int driverId) {
		return ResponseEntity.ok(driverService.getReviews(driverId));
	}

 
 
//===================================================================ComplaintModule==============================================================================

	/**
	 * GET endpoint for retrieving complaints related to a specific driver based on the driver's ID.
	 *
	 * @param driverId The ID of the driver for whom complaints are to be retrieved.
	 * @return ResponseEntity<Object> representing the HTTP response with the complaints related to the specified driver,
	 *         or HttpStatus.NOT_FOUND if no complaints are found for the specified driver.
	 */
	@GetMapping("/complaintOnDriver/{driverId}")
	public ResponseEntity<Object> complaintOnDriver(@PathVariable int driverId) {
	    return ResponseEntity.ok(complaintService.complaintOnDriver(driverId));
	}
}