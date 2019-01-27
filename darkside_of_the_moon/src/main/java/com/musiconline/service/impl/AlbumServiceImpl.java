package com.musiconline.service.impl;

import com.musiconline.models.Album;
import com.musiconline.repository.impl.AlbumRepository;
import com.musiconline.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findOne(Integer id) {
        return albumRepository.findOne(Math.toIntExact(id));
    }

    @Override
    public List<Album> findByName(String albumName) {
        return albumRepository.findByName(albumName);
    }

    @Override
    public Album create(Album album) {
        return albumRepository.create(album);
    }


    @Override
    public Album edit(Integer id, String albumName, String albumArtist, String releaseDate, Album.Genre genre, Integer numOfTracks, Double price) {
        return albumRepository.edit(id, albumName, albumArtist, releaseDate, genre, numOfTracks, price);
    }

    @Override
    public Boolean delete(Integer id) {
        return albumRepository.delete(id);
    }
}
