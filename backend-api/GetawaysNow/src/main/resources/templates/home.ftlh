<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Home Screen</title>

 <link rel="stylesheet" href="/css/global.css" />
<link rel="stylesheet" href="/css/home.css" />
<link rel="stylesheet" href="/css/navbar.css" />
<link rel="stylesheet" href="/css/listings.css" />

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" />
</head>
<body>

<!-- NAVBAR -->
<nav class="navbar">
  <div class="container-fluid">
    
    <ul class="navbar-nav flex-row align-items-center">

      <li class="nav-item">
        <div class="dropdown">
          <button class="dropdown-toggle">
            <i class="bi bi-three-dots-vertical"></i>
          </button>
         <ul class="dropdown-menu-left">
            <li><a class="dropdown-item" href="/">Home</a></li>
            <li><a class="dropdown-item" href="/favorites">Favorites</a></li>
            <li><a class="dropdown-item" href="/my_listings">View My Listings</a></li>
            <li><a class="dropdown-item" href="/listing/create">Create a Listing</a></li>
        </ul>

        </div>
      </li>

      <li class="nav-item ms-3">
        <img src="/images/Logo.jpg" alt="Logo" width="100" height="50" />
      </li>

    </ul>

    <!-- Profile Dropdown -->
    <div class="ms-auto">
      <div class="dropdown">
        <button class="dropdown-toggle">
          <img src="/images/defaultuser.jpg" 
               class="rounded-circle" width="40" height="40" />
        </button>
        <ul class="dropdown-menu-right">
          <li><a class="dropdown-item" href="/profile">My Profile</a></li>
          <li><a class="dropdown-item" href="/login">Login</a></li>
          <li><a class="dropdown-item" href="/logout">Logout</a></li>
        </ul>
      </div>
    </div>

  </div>
</nav>

<!-- Logo Centered -->
<div class="logo-container">
  <img src="/images/Logo.jpg" alt="Getaways Now Logo" class="logo" />
</div>

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

   <#assign imgs = listingImagesMap[listing.id?string]![] />

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

<script src="/scripting/navBar.js"></script>
<script src="/scripting/home.js"></script>

</body>
</html>
