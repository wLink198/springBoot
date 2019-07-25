package com.spring.demo.controller;

import com.google.gson.Gson;
import com.spring.demo.dto.StudentDto;
import com.spring.demo.entity.Account;
import com.spring.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/admin/student")
public class StudentController {

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String getList() {
        List<Account> accountList = accountRepository.findAll();
        return new Gson().toJson(
                accountList.stream()
                        .map(x -> new StudentDto(x))
                        .collect(Collectors.toList()));
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@RequestParam(value = "username", required = false) String name) {
        if (name == null || name == "" || name.length() == 0) {
            return "admin/student/form";
        }
        Account account = new Account();
        account.setUsername(name);
        accountRepository.save(account);
        return "admin/student/form";
    }
}
