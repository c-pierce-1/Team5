package com.example.GetawaysNow.listing;


import com.example.GetawaysNow.Profile.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private float pricePerNight;

    @Column(columnDefinition = "TEXT")
    private String description;


    private String rules;

    @Column(nullable = false) 
    private Float bedrooms; 

    @Column(nullable = false) 
    private Float bathrooms;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    @JsonIgnore
    private Profile profileID; 

    public Listing(Long id) {
        this.id = id;
    }

    public Listing() {
    }

    public Listing(Long id, String name, String address, String city, String state, String zipCode, Float pricePerNight, Float bedrooms, Float bathrooms,
        Profile profileID) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.pricePerNight = pricePerNight;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.profileID = profileID;
    }

    public Listing(Long id, String name, String address, String city, String state, String zipCode, Float pricePerNight, Float bedrooms, Float bathrooms, 
        Profile profileID, String description, String rules) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.pricePerNight = pricePerNight;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.profileID = profileID;
        this.description = description;
        this.rules = rules;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public float getPricePerNight() {
        return pricePerNight;
    }

    public String getDescription() {
        return description;
    }

    public String getRules() {
        return rules;
    }

    public Float getBedrooms() {
        return bedrooms;
    }

    public Float getBathrooms() {
        return bathrooms;
    }

    public Profile getProfileID() {
        return profileID;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPricePerNight(float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public void setBedrooms(Float bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBathrooms(Float bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setProfile(Profile profileID) {
        this.profileID = profileID;
    }
}