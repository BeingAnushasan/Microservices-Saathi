package com.anushasan.saathi.profileservice.controllers;


import com.anushasan.saathi.commons.model.User.User;
import com.anushasan.saathi.profileservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/service")
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/profile")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/profile")
    public void  delete(@RequestBody UUID id){
         userService.delete(id);
    }

}
