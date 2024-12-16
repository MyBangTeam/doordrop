package com.mybang.doordrop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybang.doordrop.entity.OtpRecord;

public interface OtpRepository extends JpaRepository<OtpRecord, Long> {

	OtpRecord findByMobile(String mobile);
}
