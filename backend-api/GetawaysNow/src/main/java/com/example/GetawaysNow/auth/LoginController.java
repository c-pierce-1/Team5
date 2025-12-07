package com.example.GetawaysNow.auth;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.Profile.ProfileRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final ProfileRepository profileRepository;

    public LoginController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    /* --------------------------------------------------------------
       SHOW LOGIN PAGE
       URL: GET /login
    -------------------------------------------------------------- */
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    /* --------------------------------------------------------------
       HANDLE LOGIN SUBMISSION
       URL: POST /login
    -------------------------------------------------------------- */
    @PostMapping("/login")
    public String loginSubmit(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            HttpSession session,
            Model model) {

        // Validation: both fields required
        if (username == null || username.isBlank() ||
            password == null || password.isBlank()) {
            model.addAttribute("error", "Username and password are required.");
            return "login";
        }

        // Lookup user
        Optional<Profile> optional = profileRepository.findByUsername(username);

        if (optional.isEmpty()) {
            model.addAttribute("error", "No account found with that username.");
            return "login";
        }

        Profile profile = optional.get();

        // Check password 
        if (!profile.getPassword().equals(password)) {
            model.addAttribute("error", "Incorrect password. Please try again.");
            return "login";
        }

        // store user session
        session.setAttribute("profileId", profile.getProfileId());
        session.setAttribute("username", profile.getUsername());

        return "redirect:/";
    }

    /* --------------------------------------------------------------
       LOGOUT
       URL: GET /logout
    -------------------------------------------------------------- */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
