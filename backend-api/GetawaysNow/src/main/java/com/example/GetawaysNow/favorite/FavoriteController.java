package com.example.GetawaysNow.favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

import jakarta.servlet.http.HttpSession;

@Controller
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/favorite/add")
    public String addFavorite(@RequestParam Long listingId, HttpSession session){
        Long profileId = (Long) session.getAttribute("profileId");

        if(profileId == null){
            return "redirect:/login";
        }

        try {
            favoriteService.createFavorite(profileId, listingId);
        } catch (Exception e) {
            System.out.println("Duplicate favorite attempted");
        }

        return "redirect:/listing/" + listingId;
    }

}

