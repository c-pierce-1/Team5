package com.example.getawaysnow.favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping
    public ResponseEntity<Favorite> createFavorite(@RequestParam Long profileId, @RequestParam Long listingId) {
        Favorite newFavorite = favoriteService.createFavorite(profileId, listingId);
        return ResponseEntity.ok(newFavorite);
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<Favorite>> getFavoritesByProfileId(@PathVariable Long profileId) {
        List<Favorite> favorites = favoriteService.getFavoritesByProfileId(profileId);
        return ResponseEntity.ok(favorites);
    }

    @DeleteMapping("/{favoriteId}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long favoriteId) {
        favoriteService.deleteFavorite(favoriteId);
        return ResponseEntity.noContent().build();
    }

}
