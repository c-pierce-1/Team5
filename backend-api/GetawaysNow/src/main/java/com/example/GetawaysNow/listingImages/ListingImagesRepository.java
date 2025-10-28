package com.example.GetawaysNow.listingImages;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GetawaysNow.listing.Listing;


@Repository
public interface ListingImagesRepository extends JpaRepository<ListingImages, Long> {

    List<ListingImages> findBylistingID(Listing listing);
    


}

