package com.example.GetawaysNow.listingImages;

import com.example.GetawaysNow.listing.Listing;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonIgnoreProperties("listingImages")
    private Listing listingID;

    @Column(nullable = false)
    private String imagePath;

    // ✅ Required by JPA
    public ListingImages() {}

    // ✅ Optional convenience constructor
    public ListingImages(Long id, Listing listingID, String imagePath) {
        this.id = id;
        this.listingID = listingID;
        this.imagePath = imagePath;
    }

    // ✅ Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Listing getListingID() {
        return listingID;
    }

    public void setListing(Listing listingID) {
        this.listingID = listingID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
