package com.example.getawaysnow.booking;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "ListingID")
    private Long listingId;

    @NotNull
    @Column(name = "ProfileID")
    private Long profileId;

    @NotNull
    @Column(name = "StartDate")
    private LocalDate startDate;

    @NotNull
    @Column(name = "EndDate")
    private LocalDate endDate;

    @NotNull
    @Column(name = "TotalPrice")
    private BigDecimal totalPrice;

    public Booking() {

    }

    public Booking(Long listingId, Long profileId, LocalDate startDate, LocalDate endDate, BigDecimal totalPrice) {
        this.listingId = listingId;
        this.profileId = profileId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}
