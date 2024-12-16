package com.mybang.doordrop.service;

import java.util.List;

import com.mybang.doordrop.entity.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer);

	Customer getCustomerByMobile(String mobile);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer user);

    void deleteCustomer(Long customerId);

	boolean existsByMobile(String mobile_no);

}
