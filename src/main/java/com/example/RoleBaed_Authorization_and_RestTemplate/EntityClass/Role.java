package com.example.RoleBaed_Authorization_and_RestTemplate.EntityClass;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "roleInformation")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "createAt")
    private Long createAt;
    @Column(name = "updateAt")
    private Long updateAt;
    @Column(name = "loginAt")
    private Long loginAt;
    @Column(name = "role")
    private String role;
}
