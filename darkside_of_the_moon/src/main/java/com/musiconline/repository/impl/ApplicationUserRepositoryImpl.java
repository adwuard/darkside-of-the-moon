package com.musiconline.repository.impl;

import com.musiconline.models.ApplicationUser;
import com.musiconline.repository.impl.ApplicationUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    private List<ApplicationUser> userList = new ArrayList<>();

    @Override
    public void createApplicationUser(ApplicationUser applicationUser) {
        userList.add(applicationUser);
    }

    @Override
    public ApplicationUser findByUserName(String username) {
        for (ApplicationUser user : userList) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
}
