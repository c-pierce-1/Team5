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
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing; 

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile; 

    @Column(length=500) 
    private String comment;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Review parentReview;

    public Review(Long id, Listing listing, Profile profile){
        this.id = id;
        this.listing = listing;
        this.profile = profile;
    }

    public Review(Long id, Listing listing,  Profile profile, Review parentReview){
        this.id = id;
        this.listing = listing;
        this.profile = profile;
        this.parentReview = parentReview;
    }

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Review getParentReview() {
        return parentReview;
    }

    public void setParentReview(Review parentReview) {
        this.parentReview = parentReview;
    }
}

