package com.cabapp.pro.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.RestController;

import com.cabapp.pro.dto.EmailDetails;
import com.cabapp.pro.dto.LoginDto;
 

import com.cabapp.pro.service.IAdminService;
import com.cabapp.pro.service.IComplaintMailService;
 
import com.cabapp.pro.service.ICustomerService;
import com.cabapp.pro.service.IDriverService;

@RestController
@CrossOrigin
@RequestMapping("/login")
@Validated
public class AbstractUserController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	static int otp;
	@Autowired
	ICustomerService service;

	@Autowired
	IDriverService driverService;

	@Autowired
	IAdminService adminService;

	@Autowired
	IComplaintMailService complaintService;
	
	
	/**
	 * Validates customer credentials based on the provided LoginDto.
	 *
	 * @param dto The LoginDto containing user login details.
	 * @return A LoginDto object with updated information if the user is validated,
	 *         otherwise null.
	 */
	@GetMapping("/validate")
	public LoginDto validateCustomer(@RequestBody LoginDto dto) {
		if (dto != null) {
			logger.debug("Inside validateCustomer method");
			String userName = dto.getUsername();
			String savedResponse = service.checkCustomerByUserName(userName);
			if (savedResponse != null) {

				dto.setIsUsername(true);
				dto.setEmail(savedResponse);
				return dto;
			}

			String SavedDriver = driverService.checkDriverByUserName(userName);
			if (SavedDriver != null) {
				dto.setIsUsername(true);
				dto.setEmail(savedResponse);
				return dto;
			}
			String savedAdmin = adminService.checkAdminByUserName(userName);
			if (savedAdmin != null) {
				dto.setIsUsername(true);
				dto.setEmail(savedResponse);
				return dto;
			}
		}
		return null;
	}
     
	
	/**
	 * Sends an OTP (One Time Password) email to reset the password.
	 *
	 * @param details The EmailDetails object containing email information.
	 */
	@PostMapping("/sendmail")
	public void sendMail(@Valid @RequestBody EmailDetails details) {
		otp = (int) (Math.random() * 1000000);
		details.setSubject("OTP to reset your password on Cab Booking Platform");
		details.setMsgBody("Please Enter this OTP to change your Password " + otp);
		complaintService.sendOtpMail(details);

	}
	/**
		 * @PutMapping("/changepassword") public Boolean
		 * resetPassword(@Valid @RequestBody ResetPasswordDTO resetDto ) { String otpstr
		 * = otp+""; if(resetDto.getOtp().equals(otpstr)) { boolean check =
		 * abstractUser.changePassword(resetDto.getPassword(), resetDto.getUsername());
		 * otp = (int)(Math.random()*1000000); return check; } otp =
		 * (int)(Math.random()*1000000); return false; }
		 **/
	/**
	 * @PutMapping("/changepassword") public Boolean
	 * resetPassword(@Valid @RequestBody ResetPasswordDTO resetDto ) { String otpstr
	 * = otp+""; if(resetDto.getOtp().equals(otpstr)) { boolean check =
	 * abstractUser.changePassword(resetDto.getPassword(), resetDto.getUsername());
	 * otp = (int)(Math.random()*1000000); return check; } otp =
	 * (int)(Math.random()*1000000); return false; }
	 **/

}
