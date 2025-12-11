package com.example.GetawaysNow.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.Profile.ProfileRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignupController{

    private final ProfileRepository profileRepository;

    @Autowired
    public SignupController(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @GetMapping("/signup")
    public String showSignupPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword, HttpSession session, Model model){
        if(!password.equals(confirmPassword)){
            model.addAttribute("error", "Passwords do not match.");
            return "signup";
        }

        if(profileRepository.findByUsername(username).isPresent()){
            model.addAttribute("error", "Username is taken.");
            return "signup";
        }

        Profile newUser = new Profile();
        newUser.setUsername(username);
        newUser.setPassword(password);

        profileRepository.save(newUser);

        session.setAttribute("profileId", newUser.getProfileId());
        session.setAttribute("username", newUser.getUsername());

        return "redirect:/profile/" + newUser.getProfileId();
    }
}