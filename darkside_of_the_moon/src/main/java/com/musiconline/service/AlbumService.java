package com.musiconline.service;

import com.musiconline.models.Album;

import java.util.List;

public interface AlbumService {

    List<Album> findAll();
    Album findOne(Integer id);
    List<Album> findByName(String albumName);
    Album create(Album album);
    Album edit(Integer id, String albumName, String albumArtist, String releaseDate, Album.Genre genre, Integer numOfTracks, Double price);
    Boolean delete(Integer id);

}
