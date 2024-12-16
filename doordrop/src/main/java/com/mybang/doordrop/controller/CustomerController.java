package com.mybang.doordrop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbang.doordrop.payload.request.LoginRequest;
import com.mbang.doordrop.payload.request.SignupRequest;
import com.mbang.doordrop.payload.response.CustomerInfoResponse;
import com.mybang.doordrop.entity.Customer;
import com.mybang.doordrop.service.CustomerService;
import com.mybang.doordrop.service.OtpService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService custService;
	
	@Autowired
	private OtpService otpService;
	
	@PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		  
		String mobile = loginRequest.getMobile();
		String otp = loginRequest.getOtp();
		//Validate OTP
		boolean isOtpValid = true; //otpService.validateOTP(mobile, otp);
        if (!isOtpValid) {
        	return ResponseEntity.badRequest().body("Error: Invalid OTP!");
        }
        Customer customer = new Customer();
        if (custService.existsByMobile(mobile)) {
        	customer = custService.getCustomerByMobile(mobile);
		}else {
			return ResponseEntity.badRequest().body("Error: Invalid mobile number!");
		}
        
		return ResponseEntity.ok().body(new CustomerInfoResponse(customer.getId(),
        		customer.getName(),
        		customer.getEmail()));
	}
	
    @PostMapping("signup")
    public ResponseEntity<?> addUser(@RequestBody SignupRequest request) {
		 
		  try { 
			  //Validate mobile number
			  if (custService.existsByMobile(request.getMobile())) {
			      return ResponseEntity.badRequest().body("Error: Mobile number is already in use!");
			    }

			// Create new customer's account
			  Customer customer = new Customer();
			  customer.setName(request.getName());
			  customer.setMobile(request.getMobile());
			  customer.setEmail(request.getEmail());
			  custService.createCustomer(customer); 
			  return ResponseEntity.ok("Registered successfully!");
		  
		  } 
		  catch (Exception e) 
		  { 
			  //System.out.println("Exception ::"+e); 
			  return ResponseEntity.badRequest().body("Error: Something went wrong!");
		  }
		 
    }
	
}
