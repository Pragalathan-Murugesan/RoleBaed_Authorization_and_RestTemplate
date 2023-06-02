package com.example.RoleBaed_Authorization_and_RestTemplate.ReposClass;

import com.example.RoleBaed_Authorization_and_RestTemplate.EntityClass.Role;
import com.example.RoleBaed_Authorization_and_RestTemplate.ImplementsInterfaces.LoginInter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    @Query(value = "select role_information.id, role_information.role, role_information.login_at, role_information.create_at, role_information.update_at, login_information.id, login_information.name, login_information.emailid, login_information.password, login_information.create_at, login_information.login_at, login_information.update_at, login_information.role,login_information.city from role_information Inner Join login_information On role_information.role = login_information.role where role_information.role = :role",nativeQuery = true)
    List<LoginInter>findAll(String role);
}
