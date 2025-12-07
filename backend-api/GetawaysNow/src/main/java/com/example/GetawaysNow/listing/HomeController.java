package com.example.GetawaysNow.listing;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.GetawaysNow.listingImages.ListingImages;
import com.example.GetawaysNow.listingImages.ListingImagesService;

@Controller
public class HomeController {

    private final ListingService listingService;
    private final ListingImagesService listingImagesService;

    public HomeController(ListingService listingService, ListingImagesService listingImagesService) {
        this.listingService = listingService;
        this.listingImagesService = listingImagesService;
    }

    // Default maping for the home page path is 
    // parameters for searhing include keyword(name), city, min price, max price
    @GetMapping("/")
    public String index(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Float minPrice,
            @RequestParam(required = false) Float maxPrice,
            Model model
    ) {

        // on default all listings should be displayed
        // but we can filter by the parameters
        List<Listing> listings = listingService.search(keyword, city, minPrice, maxPrice);
        
        // grabs the listing images per the listing and maps them to the id for reference
        Map<String, List<ListingImages>> listingImagesMap = listings.stream()
            .collect(Collectors.toMap(
                    l -> l.getId().toString(),
                    l -> listingImagesService.getListingImagesByListing(l.getId())
            ));

        model.addAttribute("listingImagesMap", listingImagesMap);

        model.addAttribute("listings", listings);;

        model.addAttribute("keyword", keyword);
        model.addAttribute("city", city);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);

        return "home";
    }
}
