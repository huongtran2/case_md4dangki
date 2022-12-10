package com.example.demo_case.controller;

import com.example.demo_case.model.Account;
import com.example.demo_case.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class Register {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AccountRepo accountRepo;
    @PostMapping
    public ResponseEntity register(@RequestBody Account account){
//        String password = passwordEncoder.encode(account.getPassword());
        String password = account.getPassword();
        account.setPassword(password);
        accountRepo.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
