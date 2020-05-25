package com.anushasan.saathi.profileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.anushasan.saathi"})
@EntityScan(basePackages = "com.anushasan.saathi.commons.model.User")
//@EnableJpaRepositories("com.anushasan.saathi.profileservice.repo")
public class ProfileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileServiceApplication.class, args);
    }

}
