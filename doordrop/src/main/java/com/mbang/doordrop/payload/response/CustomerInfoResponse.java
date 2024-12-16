package com.mbang.doordrop.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerInfoResponse {
	private Long id;
	private String customername;
	private String email;
	

}
