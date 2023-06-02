package com.example.RoleBaed_Authorization_and_RestTemplate.Services;

import com.example.RoleBaed_Authorization_and_RestTemplate.api_response.ApiResponse;
import com.example.RoleBaed_Authorization_and_RestTemplate.DtoClass.LoginDto;
import com.example.RoleBaed_Authorization_and_RestTemplate.EntityClass.Login;
import com.example.RoleBaed_Authorization_and_RestTemplate.EntityClass.Role;
import com.example.RoleBaed_Authorization_and_RestTemplate.ImplementsInterfaces.LoginInter;
import com.example.RoleBaed_Authorization_and_RestTemplate.ImplementsInterfaces.LoginandRoleImple;
import com.example.RoleBaed_Authorization_and_RestTemplate.JwtTokens.GenerateTokens;
import com.example.RoleBaed_Authorization_and_RestTemplate.ReposClass.LoginRepo;
import com.example.RoleBaed_Authorization_and_RestTemplate.ReposClass.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

@Service
public class LoginandRoleService implements LoginandRoleImple {
    @Autowired
    private LoginRepo loginRepo;
    @Autowired
    private ApiResponse apiResponse;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private GenerateTokens generateTokens;

    String encryptPwd;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public ApiResponse add(LoginDto loginDto) throws Exception {
        try {
            Login login = new Login();
            login.setName(loginDto.getName());
            login.setEmailID(loginDto.getEmailID());
            encryptPwd = bCryptPasswordEncoder.encode(loginDto.getPassword());
            login.setPassword(encryptPwd);
            Long epochTime = Instant.now().getEpochSecond();
            login.setCreateAt(epochTime);
            login.setRole(loginDto.getRole());
            loginRepo.save(login);

            Role role = new Role();
//    Long epochTime1 = Instant.now().getEpochSecond();
            role.setCreateAt(epochTime);
            role.setRole(loginDto.getRole());
            roleRepo.save(role);
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setData(login);
            apiResponse.setMessage("Data Added Successfully");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse login(LoginDto loginDto) throws Exception {
        try {
            Login login = loginRepo.loginApi(loginDto.getEmailID(), loginDto.getRole());
            if (login == null) {
                apiResponse.setMessage("Login Failed");
                apiResponse.setData(null);
                apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
                return apiResponse;
            }
            if (bCryptPasswordEncoder.matches(loginDto.getPassword(), login.getPassword())) {
                String token = generateTokens.generateToken(loginDto);
                HashMap<String, Object> data = new HashMap<>();
                data.put("token", token);
                apiResponse.setStatus(HttpStatus.ACCEPTED.value());
                apiResponse.setData(data);
                apiResponse.setMessage("Login Successfully");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse getAll(String role) throws Exception {
        try {
            List<LoginInter> loginInters = roleRepo.findAll(role);
            roleRepo.findAll();
            apiResponse.setData(loginInters);
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setMessage("Data Received");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return apiResponse;
    }

    @Override
    public ApiResponse users(String role) {
        List<Login> logins = loginRepo.getallb(role);
        apiResponse.setData(logins);
        apiResponse.setMessage("datarea");
        apiResponse.setStatus(HttpStatus.OK);
        return apiResponse;
    }
}
