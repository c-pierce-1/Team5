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

    @GetMapping("/")
    public String index(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Float minPrice,
            @RequestParam(required = false) Float maxPrice,
            Model model
    ) {

        List<Listing> listings = listingService.search(keyword, city, minPrice, maxPrice);

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
