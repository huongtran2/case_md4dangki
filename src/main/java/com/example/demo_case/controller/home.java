package com.example.demo_case.controller;

import com.example.demo_case.model.Account;
import com.example.demo_case.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class home {

    @Autowired
    AccountRepo accountRepo;

    @PostMapping("/login")
    public String home(){

        return "show";

    }
}
