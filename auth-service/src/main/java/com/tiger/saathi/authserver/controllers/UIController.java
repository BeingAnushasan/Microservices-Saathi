package com.tiger.saathi.authserver.controllers;

import com.anushasan.saathi.commons.model.Auth.User;
import com.tiger.saathi.authserver.service.UserDetailServiceImpl;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UIController {

    final UserDetailServiceImpl userService;

    public UIController(UserDetailServiceImpl userService) {
        this.userService = userService;
    }



    @RequestMapping(method = RequestMethod.GET, path ="/createuser")
    public String creatLocation(){
        return "signUpPage";
    }

//    @PreAuthorize("hasRole('ROLE_admin')")
    @RequestMapping(method = RequestMethod.POST ,path = "/saveuser" )
    public String saveLocation(@ModelAttribute("user") User user, ModelMap modelMap){
        User savedUser = userService.save(user);
        String msg = "User created with id:"+savedUser.getId();
        modelMap.addAttribute("msg", msg);
        return "signUpPage";
    }

}
