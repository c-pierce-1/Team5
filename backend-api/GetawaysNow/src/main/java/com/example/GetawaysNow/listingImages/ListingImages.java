package com.example.GetawaysNow.listingImages;

import com.example.GetawaysNow.listing.Listing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "listing_images")
public class ListingImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @Column(nullable = false)
    private String imagePath;

    public ListingImages() {

    }

    public ListingImages(Long id, Listing listing, String imagePath) {
        this.id = id;
        this.listing = listing;
        this.imagePath = imagePath;
    }

}
