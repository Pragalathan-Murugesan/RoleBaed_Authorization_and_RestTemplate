package com.example.RoleBaed_Authorization_and_RestTemplate.DtoClass;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoleDto {
    @NotNull(message = "Name Is Required")
    @NotEmpty(message = "Please Enter Name")
    private String name;
    @NotNull(message = "Role Is Required")
    @NotEmpty(message = "Please Enter Role")
    private String role;
}
