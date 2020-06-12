package com.anushasan.saathi.profileservice.service;

import com.anushasan.saathi.commons.model.Profile.UserProfile;

import java.util.List;
import java.util.Optional;


public interface ProfileService {
    public Optional<UserProfile> findByID(int id);
    public List<UserProfile> findAll();
    public UserProfile save(UserProfile user);
    public UserProfile update(int id, UserProfile profile);
    public void delete(int id);


}
