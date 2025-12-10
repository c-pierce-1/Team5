package com.example.GetawaysNow.favorite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.GetawaysNow.Profile.Profile;
import com.example.GetawaysNow.Profile.ProfileRepository;
import com.example.GetawaysNow.listing.Listing;
import com.example.GetawaysNow.listing.ListingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final ProfileRepository profileRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository,
            ProfileRepository profileRepository,
            ListingRepository listingRepository) {
        this.favoriteRepository = favoriteRepository;
        this.profileRepository = profileRepository;
        this.listingRepository = listingRepository;
    }

    public Favorite createFavorite(Long profileId, Long listingId) {

        if(favoriteRepository.existsByProfileProfileIdAndListingId(profileId, listingId)){
            throw new IllegalStateException("Already favorited!");
        }

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found"));

        Listing listing = listingRepository.findById(listingId)
                .orElseThrow(() -> new EntityNotFoundException("Listing not found"));

        Favorite newFavorite = new Favorite(profile, listing);
        return favoriteRepository.save(newFavorite);
    }

    public List<Favorite> getFavoritesByProfileId(Long profileId) {
        if (!profileRepository.existsById(profileId)) {
            throw new EntityNotFoundException("Profile not found");
        }
        return favoriteRepository.findByProfileProfileId(profileId);
    }

    public void deleteFavorite(Long favoriteId) {
        if (!favoriteRepository.existsById(favoriteId)) {
            throw new EntityNotFoundException("Favorite not found");
        }
        favoriteRepository.deleteById(favoriteId);
    }

}
