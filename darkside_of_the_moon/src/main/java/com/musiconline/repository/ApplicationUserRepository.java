package com.musiconline.repository.impl;

import com.musiconline.models.ApplicationUser;


public interface ApplicationUserRepository {

    void createApplicationUser(ApplicationUser applicationUser);
    ApplicationUser findByUserName(String username);

}