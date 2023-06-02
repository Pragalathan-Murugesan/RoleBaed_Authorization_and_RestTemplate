package com.example.RoleBaed_Authorization_and_RestTemplate.DtoClass;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoginDto {
    @NotNull(message = "Name Is Required")
    @NotEmpty(message = "Please Enter Name")
    private String name;
    @NotNull(message = "EmailId Is Required")
    @NotEmpty(message = "Please Enter EmailId")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String emailID;
    @NotNull(message = "Password Is Required")
    @NotEmpty(message = "Please Enter Password")
    @Size(min = 8,message = "Minimum of Digits is 8 Required")
    private String password;
    @NotNull(message = "role Is Required")
    @NotEmpty(message = "Please Enter role")
    private String role;
}
