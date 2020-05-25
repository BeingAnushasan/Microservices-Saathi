package com.anushasan.saathi.profileservice.service;

import com.anushasan.saathi.commons.model.User.User;
import com.anushasan.saathi.profileservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
     UserRepo userRepo;

    @Override
    public Optional<User> findByID(UUID id) {
        Optional<User> user = userRepo.findById(id);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {

        if(userRepo.existsById(user.getId())) return userRepo.save(user);
        else return userRepo.save(user);

    }

    @Override
    public void delete(UUID id) {
        userRepo.deleteById(id);
        return;
    }


}
