package com.anushasan.saathi.profileservice.controllers;


import com.anushasan.saathi.commons.model.Profile.UserProfile;
import com.anushasan.saathi.profileservice.service.ProfileService;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@EnableOAuth2Sso
@RequestMapping(value = "/service")
public class ProfileController {

    final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @GetMapping(value = "/profile")
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<UserProfile> findAll() {
        return profileService.findAll();
    }


    @GetMapping(value = "/profile/{id}")
    @PreAuthorize("hasRole('ROLE_operator')")
    public Optional<UserProfile> find(@PathVariable int id) {
        return profileService.findByID(id);
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


