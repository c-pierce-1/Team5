package com.example.GetawaysNow.listingImages;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.GetawaysNow.listing.Listing;


@Repository
public interface ListingImagesRepository extends JpaRepository<ListingImages, Long> {

    @Query(value = "select * from listing_images s where s.listing_id like '%' || ?1 || '%' ", nativeQuery = true)
    List<ListingImages> getListingImagesByListing(Listing listingID);
    


}

