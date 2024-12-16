package com.mybang.doordrop.serviceImpl;

import org.springframework.stereotype.Service;
import com.mybang.doordrop.entity.Customer;
import com.mybang.doordrop.repository.CustomerRepository;
import com.mybang.doordrop.service.CustomerService;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByMobile(String mobile) {
    	return customerRepository.findByMobile(mobile);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer user) {
    	Customer existingUser = customerRepository.findById(user.getId()).get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        Customer updatedUser = customerRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

	@Override
	public boolean existsByMobile(String mobile) {
		
		return customerRepository.existsByMobile(mobile);
	}

}
