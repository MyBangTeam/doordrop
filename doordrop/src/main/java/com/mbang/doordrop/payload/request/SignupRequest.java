package com.mbang.doordrop.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    @Size(min = 3, max = 20)
    private String name;
 
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    @Pattern(regexp="(^$|[0-9]{10})")
    private String mobile;
}
