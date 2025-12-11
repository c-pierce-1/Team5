<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Home Screen</title>
  <link rel="stylesheet" href="/css/global.css" />
  <link rel="stylesheet" href="/css/home.css" />
  <link rel="stylesheet" href="/css/listings.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" />
</head>

<body>

<#include "navbar.ftlh" />

<!-- Logo Centered -->
<div class="logo-container">
  <img src="/images/Logo.jpg" alt="Getaways Now Logo" class="logo" />
</div>

<#if userCity??>
    <div class="location-banner">
        <p>📍 Showing listings near <strong>${userCity}, ${userRegion}</strong></p>
    </div>
<#else>
    <div class="location-banner">
        <p>📍 Location unavailable — showing all listings</p>
    </div>
</#if>

<!-- SEARCH BAR -->
<div class="search-container">
  <form method="get" action="/" style="display:flex; gap:10px; width:100%; justify-content:center;">

    <input type="text" 
           name="keyword" 
           placeholder="Search rentals..." 
           value="${keyword!}" 
           style="flex:3;" />

    <input type="text" 
           name="city" 
           placeholder="City" 
           value="${city!}" 
           style="flex:1;" />

    <input type="number" 
           name="minPrice" 
           placeholder="Min Price" 
           value="${minPrice!}" 
           style="flex:1;" />

    <input type="number" 
           name="maxPrice" 
           placeholder="Max Price" 
           value="${maxPrice!}" 
           style="flex:1;" />

    <button type="submit">
      <i class="bi bi-search"></i>
    </button>

  </form>
</div>


<!-- LISTING RESULTS -->
<div class="listing-grid">

  <#if listings?size == 0>
    <p style="text-align:center; font-size:20px; margin-top:40px;">
      No listings match your search.
    </p>
  </#if>

 <#list listings as listing>

    <#assign key = listing.id?string />
  <#assign imgs = listingImagesMap[key]![] />



    <#if imgs?has_content>
        <#assign imgPath = imgs[0].imagePath />
    <#else>
        <#assign imgPath = "/images/placeholder.jpg" />
    </#if>

    <div class="listing-card">

        <img src="${imgPath}" alt="Listing Image" class="listing-thumb"/>

        <div class="listing-info">
            <h3>${listing.name}</h3>
            <p>${listing.city}, ${listing.state}</p>

            <p>
                <strong>$${listing.pricePerNight}</strong> / night<br/>
                ${listing.bedrooms} bd • ${listing.bathrooms} ba
            </p>

            <p class="listing-description">
                <#assign desc = listing.description!"" />
                <#if desc?length gt 80>
                    ${desc?substring(0, 80)}...
                <#else>
                    ${desc}
                </#if>
            </p>

            <a href="/listing/${listing.id}" class="view-btn">View Details</a>
        </div>

    </div>

</#list>



</div>

<script src="/scripting/home.js"></script>

</body>
</html>
