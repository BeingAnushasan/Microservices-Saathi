package com.tiger.saathi.authserver.service;


import com.anushasan.saathi.commons.model.Auth.User;
import com.anushasan.saathi.commons.model.Auth.AuthUserDetail;
import com.tiger.saathi.authserver.repo.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailRepo userDetailRepo;

    //for authentcation
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDetailRepo.findByUsername(name);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or Password wrong"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);

        return userDetails;

    }


    //for my controller
    public Optional<User> findByID(int id) {
        Optional<User> user = userDetailRepo.findById( id);
        return user;
    }


    public List<User> findAll() {
        return userDetailRepo.findAll();
    }


    public User save(User user) {
        return userDetailRepo.save(user);
    }


    public User update(int id, User user) {

        if (userDetailRepo.existsById(id))
            userDetailRepo.save(user);
        return user;

    }


    public void delete(int id) {
        userDetailRepo.deleteById(id);
        return;
    }


}
