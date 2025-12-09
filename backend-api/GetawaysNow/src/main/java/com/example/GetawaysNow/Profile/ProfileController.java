package com.example.GetawaysNow.Profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController{
    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@Valid @RequestBody Profile profile){
        Profile newProfile = profileService.createProfile(profile);
        return ResponseEntity.ok(newProfile);
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles(){
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id){
        Profile profile = profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @Valid @RequestBody Profile profileDetails){
        Profile updatedProfile = profileService.updateProfile(id, profileDetails);
        return ResponseEntity.ok(updatedProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id){
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }

}