package com.tiger.saathi.authserver.service;

import com.tiger.saathi.authserver.model.AuthUserDetail;
import com.tiger.saathi.authserver.model.User;
import com.tiger.saathi.authserver.repo.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailRepo userDetailRepo;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser= userDetailRepo.findByUsername(name);
        optionalUser.orElseThrow(()-> new  UsernameNotFoundException("Username or Password wrong"));

        UserDetails userDetails =new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);

        return userDetails;

    }

}
