package com.musiconline.service.impl;

import com.musiconline.models.ApplicationUser;
import com.musiconline.repository.impl.ApplicationUserRepository;
import com.musiconline.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public void createApplicationUser(ApplicationUser applicationUser) {
        applicationUserRepository.createApplicationUser(applicationUser);
    }

    @Override
    public ApplicationUser findByUserName(String username) {
        return applicationUserRepository.findByUserName(username);
    }
}
