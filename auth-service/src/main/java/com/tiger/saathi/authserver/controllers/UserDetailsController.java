package com.tiger.saathi.authserver.controllers;

import com.anushasan.saathi.commons.model.Auth.User;
import com.tiger.saathi.authserver.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/auth")
public class UserDetailsController {

    @Autowired
    UserDetailServiceImpl userDetailsService;

    @GetMapping("/users")
    public List<User> findAll(){
        return userDetailsService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getOneUser(@PathVariable int id){
        return userDetailsService.findByID(id);
    }


//    @PostMapping("/profile")
//    @PreAuthorize("hasRole('ROLE_operator')")
//    public UserProfile save(@RequestBody UserProfile user) {
//        return userService.save(user);
//    }
//
//    @PutMapping("/profile/{id}")
//    @PreAuthorize("hasAuthority('update_profile')")
//    public UserProfile update(@PathVariable long id, @RequestBody UserProfile user) {
//        return userService.update(id, user);
//    }
//
//    @DeleteMapping("/profile")
//    @PreAuthorize("hasRole('ROLE_operator')")
//    public void delete(@RequestBody long id) {
//        userService.delete(id);
//    }


}
