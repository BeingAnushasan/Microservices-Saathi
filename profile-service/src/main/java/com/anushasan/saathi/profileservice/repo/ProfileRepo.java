package com.anushasan.saathi.profileservice.repo;

import com.anushasan.saathi.commons.model.Profile.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<UserProfile, Integer> {
}
