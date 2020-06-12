package com.tiger.saathi.authserver.repo;

import com.anushasan.saathi.commons.model.Auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String name);
}
