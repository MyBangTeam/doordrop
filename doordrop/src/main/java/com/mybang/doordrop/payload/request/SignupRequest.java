package com.mybang.doordrop.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    @Size(max = 20)
    private String name;
 
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank(message = "Mobile number can't be empty")
    @Pattern(regexp="(^$|[0-9]{10})", message="Invalid mobile number!!!")
    private String mobile;
}
