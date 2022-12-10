package com.example.demo_case.controller;

import com.example.demo_case.model.Account;
import com.example.demo_case.service.AccountSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountSevice accountSevice;

    @GetMapping("/accounts")
    public List<Account> show(){
        return accountSevice.getAll();

    }
    @PostMapping ("/accounts")
    public List<Account> Create(){
        return accountSevice.getAll();

    }
    @PutMapping ("/accounts")
    public List<Account> Edit_Demo(){
        return accountSevice.getAll();

    }
    @DeleteMapping("/accounts")
    public List<Account> delete_Demo(){
        return accountSevice.getAll();

    }
}
