package com.example.getawaysnow.profile;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile createProfile(Profile profile) {
        if (profileRepository.existsByUsername(profile.getUsername())) {
            throw new IllegalStateException("Username already taken");
        }
        return profileRepository.save(profile);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profile with id:" + id + " not found"));
    }

    public Profile updateProfile(Long id, Profile profileDetails) {
        Profile existingProfile = getProfileById(id);

        existingProfile.setUsername(profileDetails.getUsername());
        existingProfile.setFirstName(profileDetails.getFirstName());
        existingProfile.setLastName(profileDetails.getLastName());
        existingProfile.setPassword(profileDetails.getPassword());
        existingProfile.setEmail(profileDetails.getEmail());
        existingProfile.setPhoneNum(profileDetails.getPhoneNum());

        return profileRepository.save(existingProfile);
    }

    public void deleteProfile(Long id){
        if(!profileRepository.existsById(id)){
            throw new EntityNotFoundException("Profile with id:" + id + " not found");
        }
        profileRepository.deleteById(id);
    }

}
