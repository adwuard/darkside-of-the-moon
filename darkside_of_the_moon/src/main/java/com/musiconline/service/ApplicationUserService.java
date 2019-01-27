package com.musiconline.service;

import com.musiconline.models.ApplicationUser;

public interface ApplicationUserService {
    void createApplicationUser(ApplicationUser applicationUser);
    ApplicationUser findByUserName(String username);
}
