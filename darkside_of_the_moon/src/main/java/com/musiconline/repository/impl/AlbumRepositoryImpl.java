package com.musiconline.repository.impl;
import com.google.common.collect.MoreCollectors;
import com.musiconline.models.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



@Repository
public class AlbumRepositoryImpl implements AlbumRepository {

    private List<Album> albumList = new ArrayList<>();

    @Override
    public List<Album> findAll() {
        return albumList;
    }

    @Override
    public Album findOne(Integer id)
    {
        return albumList.stream()
                .filter(album -> album.getId() == id)
//                .reduce((a, b) -> {
//                    throw new IllegalStateException("Multiple elements: " + a + ", " + b);
//                })
//                .get();
                .collect(MoreCollectors.onlyElement());
    }

    @Override
    public List<Album> findByName(String albumName) {

        return albumList.stream()
                .filter(album -> album.getAlbumName().toLowerCase().contains(albumName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Album create(Album album) {

        albumList.add(album);
        return album;
    }

    @Override
    public Album edit(Integer id, String albumName, String albumArtist, String releaseDate, Album.Genre genre, Integer numOfTracks, Double price) {

        for (Album album : albumList) {
            if (album.getId().equals(id)) {
                album.setAlbumName(albumName);
                album.setAlbumArtist(albumArtist);
                album.setReleaseDate(releaseDate);
                album.setGenre(genre);
                album.setNumOfTracks(numOfTracks);
                album.setPrice(price);
                return album;
            }
        }
        return null;
    }


    @Override
    public Boolean delete(Integer id) {

        for (int i = 0; i<albumList.size(); i++) {
            if (albumList.get(i).getId().equals(id)) {
                albumList.remove(i);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
