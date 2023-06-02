package com.example.RoleBaed_Authorization_and_RestTemplate.ImplementsInterfaces;

import com.example.RoleBaed_Authorization_and_RestTemplate.api_response.ApiResponse;
import com.example.RoleBaed_Authorization_and_RestTemplate.DtoClass.LoginDto;

public interface LoginandRoleImple {
    ApiResponse add(LoginDto loginDto) throws Exception;

    ApiResponse login(LoginDto loginDto) throws Exception;

    ApiResponse getAll(String role) throws Exception;
    ApiResponse users(String role);
}
