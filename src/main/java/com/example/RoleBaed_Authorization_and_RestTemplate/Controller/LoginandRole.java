package com.example.RoleBaed_Authorization_and_RestTemplate.Controller;

import com.example.RoleBaed_Authorization_and_RestTemplate.api_response.ApiResponse;
import com.example.RoleBaed_Authorization_and_RestTemplate.DtoClass.LoginDto;
import com.example.RoleBaed_Authorization_and_RestTemplate.Services.LoginandRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login/role/api")
public class LoginandRole {
    @Autowired
    private LoginandRoleService loginandRoleService;

    @PostMapping(value = "/add")
    public ApiResponse add(@Valid @RequestBody LoginDto loginDto) throws Exception {
        return loginandRoleService.add(loginDto);
    }

    @PostMapping(value = "/login")
    public ApiResponse login(@RequestBody LoginDto loginDto) throws Exception {
        return loginandRoleService.login(loginDto);
    }

    @GetMapping(value = "/admin/getall/{role}")
    public ApiResponse getAll(@PathVariable("role") String role) throws Exception {
        return loginandRoleService.getAll(role);
    }

    @GetMapping(value = "/user/api/users/{role}")
    public ApiResponse users(@PathVariable("role") String role){
        return loginandRoleService.users(role);
    }

}
