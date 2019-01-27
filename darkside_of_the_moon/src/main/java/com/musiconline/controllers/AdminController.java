package com.musiconline.controllers;

import com.musiconline.models.Album;
import com.musiconline.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminController {

    @Autowired
    private AlbumService albumService;



    @RequestMapping(value = "/admin/albums/view", method = RequestMethod.GET)
    public String ViewForm(){return "view";}



    @RequestMapping(value = "/admin/albums/add", method = RequestMethod.GET)
    public String addAlbumPage() {
        return "addalbum";
    }

    @RequestMapping(value = "/admin/albums/add", method = RequestMethod.POST)
    public String submitAlbumForm(
            @RequestParam("albumName") String albumName,
            @RequestParam("albumPrice") Double price,
            @RequestParam("albumArtist") String albumArtist,
            @RequestParam("releaseDate") String releaseDate,
            @RequestParam("genre") Album.Genre genre,
            @RequestParam("albumId") Integer id,
            @RequestParam("numOfTracks") Integer numOfTracks)

    {
        Album album = new Album();
        album.setAlbumName(albumName);
        album.setPrice(price);
        album.setAlbumArtist(albumArtist);
        album.setReleaseDate(releaseDate);
        album.setGenre(genre);
        album.setNumOfTracks(numOfTracks);
        album.setId(id);
        albumService.create(album);
        return "redirect:/";
    }

    @RequestMapping(value = "/admin/albums/edit/{id}", method = RequestMethod.GET)
    public String editAlbumForm(@PathVariable Integer id, Model model) {

        Album album = albumService.findOne(id);
        if (album != null) {
            model.addAttribute("albumName", album.getAlbumName());
            model.addAttribute("albumArtist", album.getAlbumArtist());
            model.addAttribute("releaseDate", album.getReleaseDate());
            model.addAttribute("genre", album.getGenre());
            model.addAttribute("numOfTracks", album.getNoOfTracks());
            model.addAttribute("albumPrice", album.getPrice());
            model.addAttribute("albumId", album.getId());

            return "editalbum";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/admin/albums/edit", method = RequestMethod.POST)
    public String saveAlbumEdit(@RequestParam(value = "albumName") String albumName,
                                @RequestParam(value = "albumPrice") Double price,
                                @RequestParam(value = "albumId") Integer id,
                                @RequestParam(value = "albumArtist") String albumArtist,
                                @RequestParam(value = "releaseDate") String releaseDate,
                                @RequestParam(value = "genre")Album.Genre genre,
                                @RequestParam(value = "numOfTracks") Integer numOfTracks)
    {
        albumService.edit(id, albumName, albumArtist, releaseDate, genre, numOfTracks, price);
        return "redirect:/";
    }

    @RequestMapping("/admin/albums/delete/{id}")
    public String deleteAlbum(@PathVariable Integer id) {
        albumService.delete(id);
        return "redirect:/";
    }

}
