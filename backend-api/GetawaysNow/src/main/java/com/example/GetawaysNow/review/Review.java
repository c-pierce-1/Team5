package com.example.GetawaysNow.review;


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
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing; 

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "profile_id", nullable = false)
    // private Profile profile; 

    @Column(length=500) 
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Review parentReview;

    public Review(Long id, Listing listing){
        this.id = id;
        this.listing = listing;
    }

    public Review(Long id, Listing listing, Review parentReview){
        this.id = id;
        this.listing = listing;
        this.parentReview = parentReview;
    }
}

