package com.mybang.doordrop.serviceImpl;

import org.springframework.stereotype.Service;

import com.mybang.doordrop.entity.OtpRecord;
import com.mybang.doordrop.repository.OtpRepository;
import com.mybang.doordrop.service.OtpService;

@Service
public class OtpServiceImpl implements OtpService {

	private OtpRepository otpRepo;
	
	@Override
	public OtpRecord findByMobile(String mobile) {
		return otpRepo.findByMobile(mobile);
	}

	@Override
	public Boolean validateOTP(String mobile, String otpNumber)
    {
        // get OTP from cache
        
        return false;
    }
}
