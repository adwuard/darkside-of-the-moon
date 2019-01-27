package com.musiconline.repository.impl;

import com.musiconline.models.Album;

import java.util.List;


public interface AlbumRepository {

    List<Album> findAll();
    Album findOne(Integer id);
    List<Album> findByName(String albumName);
    Album create(Album album);
    Album edit(Integer id, String name, String albumName, String albumPrice, Album.Genre genre, Integer numOfTracks, Double price);
    Boolean delete(Integer id);

}
