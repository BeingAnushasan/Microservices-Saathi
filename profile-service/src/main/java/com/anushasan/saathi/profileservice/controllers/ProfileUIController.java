package com.anushasan.saathi.profileservice.controllers;

import com.anushasan.saathi.commons.model.Auth.AuthUserDetail;
import com.anushasan.saathi.commons.model.Auth.User;
import com.anushasan.saathi.commons.model.Profile.UserProfile;
import com.anushasan.saathi.profileservice.service.ProfileService;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.security.core.context.SecurityContextHolder.*;

@Controller
@EnableOAuth2Sso
public class ProfileUIController {

    final ProfileService profileService;

    public ProfileUIController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/createprofile")
    public String creatLocation() {
        return "profilePage";
    }

    //    @PreAuthorize("hasRole('ROLE_admin')")
    @RequestMapping(method = RequestMethod.POST, path = "/saveprofile")
    public String saveLocation(@ModelAttribute("userprofile") UserProfile profile, ModelMap modelMap) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            System.out.println("principle is obj");
            profile.setUsername(username);
        } else {
            String username = principal.toString();
            System.out.println("principle is string");
            profile.setUsername(username);
        }


        UserProfile savedProfile = profileService.save(profile);

        String msg = "User profile created with id:" + savedProfile.getUsername();
        modelMap.addAttribute("msg", msg);
        return "profilePage";

    }

}
