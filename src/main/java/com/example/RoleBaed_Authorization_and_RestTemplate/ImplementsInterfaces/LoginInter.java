package com.example.RoleBaed_Authorization_and_RestTemplate.ImplementsInterfaces;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface LoginInter {
    Long getId();
    String getName();
     String getEmailID();
     String getPassword();
     String getRole();
     Long getCreateAt();
     Long getUpdateAt();
     Long getLoginAt();
     String getCity();
}
