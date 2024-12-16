package com.mybang.doordrop.util;

import java.security.SecureRandom;

public class DRSecurityUtil {
	
	public int generateOTPByLen(int len)
	  {
	    SecureRandom sr = new SecureRandom();
	    return sr.nextInt(len);
	  }
}
