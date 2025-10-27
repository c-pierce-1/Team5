package com.example.GetawaysNow.listing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Integer bedrooms; 

    @Column(nullable = false) 
    private Float bathrooms;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "profile_id", nullable = false)
    // private Profile profile; 

    public Listing(Long id) {
        this.id = id;
    }

    public Listing(Long id, String name, String address, String city, String state, String zipCode, Float pricePerNight, Integer bedrooms, Float bathrooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.pricePerNight = pricePerNight;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
    }

     public Listing(Long id, String name, String address, String city, String state, String zipCode, Float pricePerNight, Integer bedrooms, Float bathrooms, 
        String description, String rules) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.pricePerNight = pricePerNight;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.description = description;
        this.rules = rules;
    }

}
