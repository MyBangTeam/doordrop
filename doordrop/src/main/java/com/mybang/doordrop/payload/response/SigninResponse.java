package com.mybang.doordrop.payload.response;

import lombok.Data;

@Data
public class SigninResponse {

	private CustomerInfoResponse info;
	private String description;
	private String statusCode;
}
