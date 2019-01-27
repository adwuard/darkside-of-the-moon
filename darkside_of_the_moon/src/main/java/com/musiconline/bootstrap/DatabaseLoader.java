package com.musiconline.bootstrap;


import com.musiconline.models.Album;
import com.musiconline.models.ApplicationUser;
import com.musiconline.repository.impl.AlbumRepository;
import com.musiconline.repository.impl.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import static com.musiconline.models.Album.Genre.Classical;
import static com.musiconline.models.Album.Genre.Country;
import static com.musiconline.models.Album.Genre.Pop;


@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        /*
            Add some musics
         */
        Album Moana = new Album(1,"Moana","Soundtrack","November 18, 2016",Pop,40,8.39);
        albumRepository.create(Moana);
        Album PTX = new Album(2,"PTX Vol. IV - Classics","Pentatonix","April 7, 2017",Pop,7,5.99);
        albumRepository.create(PTX);
        Album Devide = new Album(3,"Divide (Deluxe Version)","Ed Sheeran","March 3, 2017",Pop,16,13.99);
        albumRepository.create(Devide);
        Album MozartForMeditation = new Album(4,"Mozart For Meditation","Wolfgang Amadeus Mozart","January 17, 1995",Classical,11,8.56);
        albumRepository.create(MozartForMeditation);
        Album Unbreakable = new Album(5,"Unbreakable","Selah","March 24, 2017",Country,11,11.49);
        albumRepository.create(Unbreakable);



        /*
            Add some users
         */
        ApplicationUser edward = new ApplicationUser(1, "edward", "123456", Boolean.TRUE);
        applicationUserRepository.createApplicationUser(edward);
        ApplicationUser admin = new ApplicationUser(4, "a", "1", Boolean.TRUE);
        applicationUserRepository.createApplicationUser(admin);
    }
}
