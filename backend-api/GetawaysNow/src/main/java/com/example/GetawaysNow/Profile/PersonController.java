package com.example.GetawaysNow.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController{
    private final ProfileService profileService;

    @Autowired
    public PersonController(ProfileService profileService){
        this.profileService = profileService;
    }

    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable Long id, Model model){
        Profile profile = profileService.getProfileById(id);
        model.addAttribute("profile", profile);
        return "profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(Profile profile){
        profileService.updateProfile(profile.getProfileId(), profile);
        return "redirect:/profile/" + profile.getProfileId();
    }
}