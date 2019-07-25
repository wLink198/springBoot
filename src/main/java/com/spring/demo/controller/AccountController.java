package com.spring.demo.controller;

import com.spring.demo.entity.Account;
import com.spring.demo.entity.AccountCredential;
import com.spring.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/account")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        Account account = new Account();
        account.setUsername("wtf");

        account.addAccountCredentialSet(new AccountCredential());

        accountRepository.save(account);
        return "admin/student/form";
    }
}
