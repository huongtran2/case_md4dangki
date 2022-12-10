package com.example.demo_case.service;

import com.example.demo_case.model.Account;
import com.example.demo_case.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountSevice implements IAccountService {
    @Autowired
    AccountRepo accountRepo;
    @Override
    public List<Account> getAll() {
        return (List<Account>) accountRepo.findAll();
    }

    @Override
    public void save(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void delete(Long id) {
        accountRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Account account = accountRepo.findByUsername(username);
        return new User(account.getUsername(),account.getPassword(),account.getRoles());
    }
}
