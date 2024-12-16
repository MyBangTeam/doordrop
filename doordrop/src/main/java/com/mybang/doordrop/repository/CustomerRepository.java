package com.mybang.doordrop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybang.doordrop.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByMobile(String mobile);
	int countByMobile(String mobile);
	boolean existsByMobile(String mobile);
}
