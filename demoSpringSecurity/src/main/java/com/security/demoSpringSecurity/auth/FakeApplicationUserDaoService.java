package com.security.demoSpringSecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.security.demoSpringSecurity.security.ApplicationUserRole.*;
@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{
    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream().
                filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
    }
    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode("password123"),
                        "annasmith",
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "linda",
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        MANAGEMENT.getGrantedAuthorities(),
                        passwordEncoder.encode("password123"),
                        "tom",
                        true,
                        true,
                        true,
                        true)
        );
        return applicationUsers;
    }
}
