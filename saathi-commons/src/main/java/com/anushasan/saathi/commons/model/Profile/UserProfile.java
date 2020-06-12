package com.anushasan.saathi.commons.model.Profile;



import com.anushasan.saathi.commons.model.Auth.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "userprofile")
@Data
public class UserProfile {

    public UserProfile() {
    }

    public UserProfile(UserProfile userProfile) {
        this.id=userProfile.getId();
        this.firstName=userProfile.getFirstName();
        this.lastName=userProfile.getLastName();
        this.birthday=userProfile.getBirthday();
        this.gender=userProfile.getGender();
        this.phoneNumber=userProfile.getPhoneNumber();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "city")
    private String city;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date birthday;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//



}
