package com.example.demo_case.validate;

import com.example.demo_case.model.Account;
import com.example.demo_case.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class Validate_Trung_Name_Account implements Validator {
    @Autowired
    IAccountService accountService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Account account = (Account) target;
        List<Account> accounts = accountService.getAll();
        for (Account a : accounts) {
            if (account.getUsername().equals(a.getUsername())) {
                errors.rejectValue("username", "", "Trung name");
                return;
            }
            if (account.getPassword().equals(a.getPassword())) {
                errors.rejectValue("password", "", "Trung password");
                return;
            }
            if (account.getPhone().equals(a.getPhone())) {
                errors.rejectValue("phone", "", "Trung phone");
                return;
            }
            if (account.getEmail().equals(a.getEmail())) {
                errors.rejectValue("email", "", "Trung email");
                return;
            }

        }
    }
}
