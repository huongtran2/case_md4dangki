package com.example.demo_case.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private Double phone;
    private String email;
    private Date birthday;
    private String address;
    private String identity;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="roles_id")
    private List<Roles> roles;
}
