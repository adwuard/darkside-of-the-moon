package com.musiconline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SiteController {

    @RequestMapping(value = "/about")
    public String aboutPage() {
        return "about"; // view
    }

    @RequestMapping(value = "/contact")
    public String contactPage() {
        return "contact";
    }

    @RequestMapping(value = "/careers")
    public String careersPage() {
        return "careers";
    }


}
