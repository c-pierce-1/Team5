package com.example.GetawaysNow.listing;

import java.util.ArrayList;
import java.util.List;

import com.example.GetawaysNow.listingImages.ListingImages;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "listing",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"address", "city"}, name = "UK_address_city")
    }
)
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false) 
    private String city; 

    @Column(nullable = false) 
    private String address;

    @Column(nullable = false) 
    private String state;

    @Column(nullable = false) 
    private String zipCode;

    @Column(nullable = false) 
    private Float pricePerNight;

    @Column(length=500) 
    private String description;

    private String rules;

    @Column(nullable = false) 
    private Integer Bedrooms; 

    @Column(nullable = false) 
    private Integer Bathrooms;



    @OneToMany(mappedBy = "listing")
    @JsonIgnoreProperties("listing")
    private List<ListingImages> ListingImages = new ArrayList<>(); 

    public Listing(Long id) {
        this.id = id;
    }

    public Listing(Long id, String name, String address) {
        this.id = id;
    }

}
