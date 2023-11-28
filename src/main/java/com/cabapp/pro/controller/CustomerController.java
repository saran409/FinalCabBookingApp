package com.cabapp.pro.controller;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.cabapp.pro.dto.*;
import com.cabapp.pro.entity.*;
import com.cabapp.pro.service.*;
import com.cabapp.pro.util.*;
 
import io.swagger.annotations.Api;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.validation.Valid;
 
@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
@Validated
@Api
public class CustomerController {
 
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
 
    @Autowired
    private ICustomerService service;
 
    @Autowired
    private ITripBookingService tripService;
 
    @Autowired
    private IDriverService driverService;
 
    @Autowired
    private IComplaintService complaintService;
 
    public CustomerController() {
        logger.info("Inside Customer controller");
    }
  
    /**
     * Saves a new customer.
     *
     * This endpoint receives a CustomerRequestSubmitDTO, converts it to a Customer entity,
     * and saves the customer using the service. Returns the saved customer information as a CustomerResponseDTO.
     *
     * @param dto The CustomerRequestSubmitDTO containing customer information.
     * @return CustomerResponseDTO representing the saved customer. Returns null if the provided DTO is null.
     */
 
    @PostMapping("/register/customer")
    public ResponseEntity<CustomerResponseDTO> saveCustomer(@Valid @RequestBody CustomerRequestSubmitDTO dto) {
        logger.debug("Inside saveCustomer method");
        if (dto != null) {
            CustomerDTOMapper dtoConverter = new CustomerDTOMapper();
            Customer customer = dtoConverter.getCustomerFromCustomerDTO(dto);
            Customer savedInfo = service.insertCustomer(customer);
            CustomerResponseDTO savedDto= dtoConverter.getCustomerDTOFromCustomer(savedInfo);
            return new ResponseEntity<CustomerResponseDTO>(savedDto, HttpStatus.CREATED);
        } else {
            logger.warn("Received null DTO for saving customer.");
            return null;
        }
    }
//===========================================================================================================================================================================================================================================================================================================================================
 
    /**
     * Retrieves a customer by ID.
     *
     * This endpoint fetches a customer by the provided customer ID and returns the result as a CustomerResponseDTO.
     *
     * @param cId The ID of the customer to retrieve.
     * @return CustomerResponseDTO representing the customer information.
     */
    @GetMapping("/customerby/{cId}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable int cId) {
        logger.debug("Inside getCustomerById method");
        CustomerDTOMapper dtoConverter = new CustomerDTOMapper();
        CustomerResponseDTO customerDto= dtoConverter.getCustomerDTOFromCustomer(service.viewCustomer(cId));
        return new ResponseEntity<CustomerResponseDTO>(customerDto, HttpStatus.OK);
    }
    
  //===========================================================================================================================================================================================================================================================================================================================================
    
    /**
     * Retrieves a customer by ID.
     *
     * This endpoint fetches a customer by the provided customer ID and returns the result as a CustomerResponseDTO.
     *
     * @param cId The ID of the customer to retrieve.
     * @return CustomerResponseDTO representing the customer information.
     */
    @GetMapping("/customerbyName/{cName}")
    public ResponseEntity<CustomerResponseDTO> getCustomerByName(@PathVariable String cName) {
        logger.debug("Inside getCustomerByName method");
        CustomerDTOMapper dtoConverter = new CustomerDTOMapper();
        CustomerResponseDTO customerDto= dtoConverter.getCustomerDTOFromCustomer(service.viewCustomerByCustomerName(cName));
        return new ResponseEntity<CustomerResponseDTO>(customerDto, HttpStatus.OK);
    }
    
 

    
 
//===========================================================================================================================================================================================================================================================================================================================================   
    /**
     * Updates a customer by ID.
     *
     * This endpoint receives a Customer entity and updates the customer with the provided ID.
     * Returns the updated customer information as a CustomerResponseDTO.
     *
     * @param customer The Customer entity containing updated customer information.
     * @param id The ID of the customer to update.
     * @return CustomerResponseDTO representing the updated customer information.
     */
    @PutMapping("/update/{id}")
    public CustomerResponseDTO updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        logger.debug("Inside updateCustomer method");
        CustomerDTOMapper dtoConverter = new CustomerDTOMapper();
        return dtoConverter.getCustomerDTOFromCustomer(service.updateCustomer(customer, id));
    }
 
//===========================================================================================================================================================================================================================================================================================================================================    
 
    /**
     * Deletes a customer by ID.
     *
     * This endpoint deletes a customer by the provided customer ID and returns the deleted customer information as a CustomerResponseDTO.
     *
     * @param id The ID of the customer to delete.
     * @return CustomerResponseDTO representing the deleted customer information.
     */
    @DeleteMapping("/delete/{id}")
    public CustomerResponseDTO deleteCustomerById(@PathVariable int id) {
        logger.debug("Inside deleteCustomerById method");
        CustomerDTOMapper dtoConverter = new CustomerDTOMapper();
        CustomerResponseDTO deletedCustomer = dtoConverter.getCustomerDTOFromCustomer(service.deleteCustomer(id));
        return deletedCustomer;
    }
 
//============================================================TripBooking API's=================================================================================================================================================
    /**
     * Retrieves a list of cabs based on the specified current location.
     *
     * @param currentLocation The current location for cab searching.
     * @return ResponseEntity<List<CabCurrentBookingResponseDTO>> representing the HTTP response with a list of cabs at the specified location.
     */
    @GetMapping("/searchCab/{currentLocation}")
    public ResponseEntity<List<CabCurrentBookingResponseDTO>> searchCabBasedOnLocations(@PathVariable String currentLocation) {
        logger.debug("Inside searchCabBasedOnLocations method with current location: {}", currentLocation);
        List<Cab> allCabs = service.getCabByLocations(currentLocation);
        CabDTOMapper converter = new CabDTOMapper();
        List<CabCurrentBookingResponseDTO> cabs = new ArrayList<>();
        for (Cab b : allCabs) {
            cabs.add(converter.getCurrentCabBookingDTOFromCab(b));
        }
        return new ResponseEntity<List<CabCurrentBookingResponseDTO>>(cabs, HttpStatus.OK);
    }
    
    @GetMapping("/giveReview/{tripBookingId}")
    public void  addReviewToTrip(@PathVariable int tripBookingId) {
    	tripService.addReviewToTrip(tripBookingId);
    }
    
//===========================================================================================================================================================================================================================================================================================================================================   
    /**
     * Adds a new trip based on the provided trip details.
     *
     * @param trip The TripBookingRequestSubmitDTO containing the details for the new trip.
     * @return ResponseEntity<TripBookingResponseDTO> representing the HTTP response with the details of the added trip.
     */
    @PostMapping("/trip")
    public ResponseEntity<TripBookingResponseDTO> addTrip(@Valid @RequestBody TripBookingRequestSubmitDTO trip) {
        logger.debug("Inside addTrip method");
       
        TripBookingDTOMapper converter = new TripBookingDTOMapper();
        TripBooking tripBooking = converter.getTripBookingFromTripBookingDTO(trip);
       //tripService.insertTripBooking(tripBooking)
        TripBooking booking = tripService.insertTripBooking(tripBooking);
        if(booking != null)
        {
        	TripBookingResponseDTO finalbooking= converter.getTripBookingDTOFromTripBooking(booking);
        	return new ResponseEntity<TripBookingResponseDTO>(finalbooking,HttpStatus.OK);
        }
        return null;
    }
//===========================================================================================================================================================================================================================================================================================================================================
    /**
     * Retrieves the current trip details for a user based on their user ID.
     *
     * @param userId The ID of the user for whom the current trip details are retrieved.
     * @return TripBookingResponseDTO representing the details of the current trip for the specified user.
     */
    @GetMapping("/tripDetails/{userId}")
    public TripBookingResponseDTO getCurrentTripByUserId(@PathVariable int userId) {
        logger.debug("Inside getCurrentTripByUserId method for user ID: {}", userId);
        if (userId != 0) {
            TripBookingDTOMapper converter = new TripBookingDTOMapper();
            return converter.getTripBookingDTOFromTripBooking(service.getTripBookingByUserId(userId));
        }
        return null;
    }
//===========================================================================================================================================================================================================================================================================================================================================
    /**
     * Retrieves a list of all trip bookings for a customer based on their customer ID.
     *
     * @param custId The ID of the customer for whom trip bookings are retrieved.
     * @return ResponseEntity<List<TripBookingEndTripCustomerResponseDTO>> representing the HTTP response with a list of trip bookings for the specified customer.
     */
    @GetMapping("/allTrips/{custName}")
    public ResponseEntity<List<TripBookingEndTripCustomerResponseDTO>> getAllTripBooking(@PathVariable String custName) {
        logger.debug("Inside getAllTripBooking method for customer ID: {}", custName);
        TripBookingDTOMapper converter=new TripBookingDTOMapper();
        List<TripBooking> savedCustomer = tripService.viewAllTripsCustomer(custName);
        List<TripBookingEndTripCustomerResponseDTO> finalList=new ArrayList<>();
        for(TripBooking t:savedCustomer) {
        	finalList.add(converter.getTripBookingEndTripCustomerDTOFromTripBooking(t));
        }
        if (finalList != null) {
            return new ResponseEntity<>(finalList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//===========================================================================================================================================================================================================================================================================================================================================
    /**
     * Updates an existing trip booking based on the provided trip details.
     *
     * @param tripBooking The TripBooking object containing the details to be updated.
     * @return TripBooking representing the updated trip booking.
     */

    @PutMapping("/update/booking")
    public TripBooking updateBooking(@RequestBody TripBooking tripBooking) {
        logger.debug("Inside updateBooking method");
        if (tripBooking != null) {
            return tripService.updateTripBooking(tripBooking);
        }
        return null;
    }
//===========================================================================================================================================================================================================================================================================================================================================
    /**
     * Cancels a trip booking based on the specified trip ID.
     *
     * @param tripId The ID of the trip to be canceled.
     * @return TripBooking representing the canceled trip booking.
     */
    @DeleteMapping("/{tripId}")
    public TripBooking cancelBooking(@PathVariable int tripId) {
        logger.debug("Inside cancelBooking method for trip ID: {}", tripId);
        if (tripId != 0) {
            return tripService.deleteTripBooking(tripId);
        }
        return null;
    }
//========================================================complaint related code==========================================================================================================================

    /**
     * POST endpoint for saving a new complaint.
     *
     * @param complaint The Complaint object to be saved.
     * @return ResponseEntity<Object> representing the HTTP response with the saved complaint or an error.
     */
    @PostMapping("/complaint/save")
    public ResponseEntity<Object> saveComplaint(@RequestBody Complaint complaint) {
        logger.debug("Inside save complaint method");
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(complaintService.createComplaint(complaint));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }
    /**
     * GET endpoint for retrieving complaints by customer ID.
     *
     * @param userId The ID of the customer for whom complaints are to be retrieved.
     * @return ResponseEntity<Object> representing the HTTP response with the complaints or an error.
     */
    @GetMapping("/complaintByCustomer/{id}")
    public ResponseEntity<Object> findComplaintsByUser(@PathVariable("id") int userId) {
        logger.debug("Inside find complaint by user method");

 
        try {
            return ResponseEntity.status(HttpStatus.OK).body(complaintService.complaintByCustomer(userId));
        } catch(Exception exception) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
        }
    }
 
	   

	//===================================================Review Related Code==============================================================================================================
    /**
     * POST endpoint for adding a review for a specific driver.
     *
     * @param driverId The ID of the driver to whom the review is being added.
     * @param review The Review object containing the details of the review.
     * @return String representing the result of the review addition operation, typically indicating success or failure.
     */
    @PostMapping("/giveReview/{driverId}")
    public String addReview(@PathVariable int driverId,  @RequestBody Review review) {
        return driverService.addReview(driverId, review);
    }
	}
