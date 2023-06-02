package com.example.RoleBaed_Authorization_and_RestTemplate.ReposClass;

import com.example.RoleBaed_Authorization_and_RestTemplate.EntityClass.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepo extends JpaRepository<Login,Long> {
    @Query(value = "select * from login_information where emailid = :emailID and  role = :role",nativeQuery = true)
    Login loginApi(String emailID, String role);
    @Query(value = "select * from login_information where name = :role",nativeQuery = true)
    List<Login> getallb(String role);
}
