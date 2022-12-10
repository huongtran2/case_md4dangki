package com.example.demo_case.repository;


import com.example.demo_case.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AccountRepo extends CrudRepository<Account, Long> {

        Account findByUsername(String username);

}
