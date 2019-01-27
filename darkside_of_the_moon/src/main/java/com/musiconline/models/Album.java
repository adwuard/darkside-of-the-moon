package com.musiconline.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Album {
   

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setNumOfTracks(Integer numOfTracks) {
        this.numOfTracks = numOfTracks;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public Integer getNoOfTracks() {
        return numOfTracks;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public enum Genre {
        Classical, Jazz, Blue,
        Electric, Pop, Metal,
        HipHop, Country, Indie,
        Folk, Funk, Punk
    }
    /*
        Instance Data
     */
    private Integer id;
    private String albumName;
    private String albumArtist;
    private String releaseDate;
    private Genre genre;
    private Integer numOfTracks;
    private Double price;

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAlbumName() {
        return albumName;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }
}



