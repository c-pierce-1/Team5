package com.example.GetawaysNow.listingImages;

import com.example.GetawaysNow.listing.Listing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listingID;

    @Column(nullable = false)
    private String imagePath;

    public ListingImages(Long id, Listing listingID, String imagePath) {
        this.id = id;
        this.listingID = listingID;
        this.imagePath= imagePath;
    }

}
