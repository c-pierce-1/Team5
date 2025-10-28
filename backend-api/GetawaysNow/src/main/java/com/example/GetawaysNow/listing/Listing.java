package com.example.GetawaysNow.listing;

import com.example.GetawaysNow.profile.Profile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    private Float pricePerNight;

    @Column(length=500) 
    private String description;

    private String rules;

    @Column(nullable = false) 
    private Integer bedrooms; 

    @Column(nullable = false) 
    private Float bathrooms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile; 

    public Listing(Long id) {
        this.id = id;
    }

    public Listing() {
        // Default no-arg constructor is often required by JPA
    }

    public Listing(Long id, String name, String address, String city, String state, String zipCode, Float pricePerNight, Integer bedrooms, Float bathrooms,
        Profile profile) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.pricePerNight = pricePerNight;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.profile = profile;
    }

    public Listing(Long id, String name, String address, String city, String state, String zipCode, Float pricePerNight, Integer bedrooms, Float bathrooms, 
        Profile profile, String description, String rules) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.pricePerNight = pricePerNight;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.profile = profile;
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

    public Float getPricePerNight() {
        return pricePerNight;
    }

    public String getDescription() {
        return description;
    }

    public String getRules() {
        return rules;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public Float getBathrooms() {
        return bathrooms;
    }

    public Profile getProfile() {
        return profile;
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

    public void setPricePerNight(Float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBathrooms(Float bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}