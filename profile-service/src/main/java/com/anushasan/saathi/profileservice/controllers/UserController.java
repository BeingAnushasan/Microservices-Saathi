package com.anushasan.saathi.profileservice.controllers;


import com.anushasan.saathi.commons.model.User.User;
import com.anushasan.saathi.profileservice.service.UserService;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@EnableOAuth2Sso
@RequestMapping(value = "/service")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/profile")
    @PreAuthorize("hasAuthority('read_profile')")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/profile")
    @PreAuthorize("hasAuthority('create_profile')")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping(value = "/profile/{id}")
    @PreAuthorize("hasAuthority('read_profile')")
    public Optional<User> find(@PathVariable int id) {
        return userService.findByID(id);
    }


    @DeleteMapping("/profile")
    @PreAuthorize("hasAuthority('delete_profile')")
    public void  delete(@RequestBody int id){
         userService.delete(id);
    }

    

}
