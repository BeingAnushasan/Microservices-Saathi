package com.anushasan.saathi.profileservice.service;

import com.anushasan.saathi.commons.model.User.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserService {
    public Optional<User> findByID(UUID id);
    public List<User> findAll();
    public User save(User user);
    public User update(User user);
    public void delete(UUID id);


}
