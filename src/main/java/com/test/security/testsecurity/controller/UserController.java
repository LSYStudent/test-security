package com.test.security.testsecurity.controller;

import com.test.security.testsecurity.model.User;
import com.test.security.testsecurity.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService targetService;

    @GetMapping(value = "/list")
    public List<User> list() {
        return targetService.list();
    }

    @PostMapping(value = "/save")
    public Boolean save(@RequestBody User user) {
        return targetService.save(user);
    }
}
