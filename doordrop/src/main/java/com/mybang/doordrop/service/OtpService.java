package com.mybang.doordrop.service;

import com.mybang.doordrop.entity.OtpRecord;

public interface OtpService {
	
	OtpRecord findByMobile(String mobile);
	Boolean validateOTP(String mobile, String otpNumber);

}
