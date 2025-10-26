package com.example.Getaways.Now.listing;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

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
    public Long id;

    @NotBlank
    @Column(nullable = false)
    public String name;
    
    // Ensure city is marked as a column
    @Column(nullable = false) 
    public String city; 
    public String address;
    public String state;
    public String zipCode;
    public Float pricePerNight;
    public String description;
    public String rules;
    public Integer Bedrooms; 
    public Integer Bathrooms;

    // @OneToMany(mappedBy = "listing")
    // @JsonIgnoreProperties("listing")
    // public List<ListingImage> ListingImages = new ArrayList<>();

    public Listing(Long id) {
        this.id = id;
    }

    public Listing(Long id, String name, String address) {
        this.id = id;
    }
}