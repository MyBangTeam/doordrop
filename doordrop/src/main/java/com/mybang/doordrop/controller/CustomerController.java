package com.mybang.doordrop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybang.doordrop.entity.Customer;
import com.mybang.doordrop.payload.request.LoginRequest;
import com.mybang.doordrop.payload.request.SignupRequest;
import com.mybang.doordrop.payload.response.CustomerInfoResponse;
import com.mybang.doordrop.payload.response.SigninResponse;
import com.mybang.doordrop.payload.response.SignupResponse;
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
		  
		SigninResponse response = new SigninResponse();
		String mobile = loginRequest.getMobile();
		String otp = loginRequest.getOtp();
		//Validate OTP
		boolean isOtpValid = true; //otpService.validateOTP(mobile, otp);
        if (!isOtpValid) {
        	
        	response.setDescription("Invalid OTP!");
            response.setStatusCode("0000");
    		return new ResponseEntity<>(response,HttpStatus.OK);
        }
        Customer customer = new Customer();
        if (custService.existsByMobile(mobile)) {
        	customer = custService.getCustomerByMobile(mobile);
		}else {
			response.setDescription("Invalid mobile number!");
            response.setStatusCode("0000");
    		return new ResponseEntity<>(response,HttpStatus.OK);
		}
        CustomerInfoResponse info = new CustomerInfoResponse(customer.getId(),
        		customer.getName(),
        		customer.getEmail());
        response.setInfo(info);
        response.setDescription("SUCCESS");
        response.setStatusCode("1111");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
    @PostMapping("signup")
    public ResponseEntity<?> addUser(@Valid @RequestBody SignupRequest request) {
		 
    	SignupResponse response = new SignupResponse();
    	
		  try { 
			  //Validate mobile number
			  if (custService.existsByMobile(request.getMobile())) {
			      response.setDescription("Mobile number is already in use!");
				  response.setStatusCode("0000");
				  return new ResponseEntity<>(response,HttpStatus.OK);
			    }

			// Create new customer's account
			  Customer customer = new Customer();
			  customer.setName(request.getName());
			  customer.setMobile(request.getMobile());
			  customer.setEmail(request.getEmail());
			  custService.createCustomer(customer); 
			  
			  
			  response.setDescription("Registered successfully!");
			  response.setStatusCode("1111");
			  return new ResponseEntity<>(response,HttpStatus.OK);
		  
		  } 
		  catch (Exception e) 
		  { 
			  System.out.println("Exception ::"+e); 
			  response.setDescription("Something went wrong!");
			  response.setStatusCode("0000");
			  return new ResponseEntity<>(response,HttpStatus.OK);
		  }
		 
    }
	
}
