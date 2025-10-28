package com.example.GetawaysNow.review;

import com.example.GetawaysNow.Profile.Profile;
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
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listingID;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profileID;

    @Column(length = 500)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Review parentReview;

    // ✅ Default constructor required by JPA and Jackson
    public Review() {}

    public Review(Long id, Listing listingID, Profile profileID) {
        this.id = id;
        this.listingID = listingID;
        this.profileID = profileID;
    }

    public Review(Long id, Listing listingID, Profile profileID, Review parentReview) {
        this.id = id;
        this.listingID = listingID;
        this.profileID = profileID;
        this.parentReview = parentReview;
    }

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Listing getListing() { return listingID; }
    public void setListing(Listing listingID) { this.listingID = listingID; }

    public Profile getProfile() { return profileID; }
    public void setProfile(Profile profileID) { this.profileID = profileID; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Review getParentReview() { return parentReview; }
    public void setParentReview(Review parentReview) { this.parentReview = parentReview; }
}


