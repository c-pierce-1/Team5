package com.example.GetawaysNow.listing;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.GetawaysNow.listingImages.ListingImages;
import com.example.GetawaysNow.listingImages.ListingImagesService;
import com.example.GetawaysNow.location.IpLocationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ListingService listingService;
    private final ListingImagesService listingImagesService;

    @Autowired
    private IpLocationService ipLocationService;

    public HomeController(ListingService listingService,
                          ListingImagesService listingImagesService) {
        this.listingService = listingService;
        this.listingImagesService = listingImagesService;
    }

    // Home page + search filters
    @GetMapping("/")
    public String index(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Float minPrice,
            @RequestParam(required = false) Float maxPrice,
            Model model,
            HttpSession session
    ) {

        List<Listing> listings = listingService.search(keyword, city, minPrice, maxPrice);

        Map<String, List<ListingImages>> listingImagesMap = listings.stream()
                .collect(Collectors.toMap(
                        l -> l.getId().toString(),
                        l -> listingImagesService.getListingImagesByListing(l.getId())
                ));

        model.addAttribute("listingImagesMap", listingImagesMap);
        model.addAttribute("listings", listings);

        // Pass filters back to page
        model.addAttribute("keyword", keyword);
        model.addAttribute("city", city);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);

        try {
            String clientIp = ipLocationService.getClientIp();
            IpLocationService.LocationResponse loc =
                    ipLocationService.getLocationFromIp(clientIp);

            if (loc != null) {
                model.addAttribute("userCity", loc.city);
                model.addAttribute("userRegion", loc.region);
                model.addAttribute("userCountry", loc.country_name);
            }

        } catch (Exception ex) {
            System.out.println("IP location lookup failed: " + ex.getMessage());
        }

        return "home";
    }
}
