package com.anushasan.saathi.profileservice.service;

import com.anushasan.saathi.commons.model.Profile.UserProfile;
import com.anushasan.saathi.profileservice.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepo profileRepo;

    @Override
    public Optional<UserProfile> findByID(int id) {
        Optional<UserProfile> profile = profileRepo.findById(id);
        return profile;
    }

    @Override
    public List<UserProfile> findAll() {
        return profileRepo.findAll();
    }

    @Override
    public UserProfile save(UserProfile profile) {
        return profileRepo.save(profile);
    }

    @Override
    public UserProfile update(int id, UserProfile profile) {

        if (profileRepo.existsById(id))
            profileRepo.save(profile);
            return profile;

    }

    @Override
    public void delete(int id) {
        profileRepo.deleteById(id);
        return;
    }


}
