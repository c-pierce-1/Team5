<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${listing.name}</title>

    <link rel="stylesheet" href="/high-fidelity-prototype/Style-Sheet.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
</head>

<body>

<!-- NAV BAR (unchanged from your layout) -->
<nav class="navbar">
    <div class="container-fluid">
        <ul class="navbar-nav flex-row align-items-center">
            <li class="nav-item">
                <div class="dropdown">
                    <button class="dropdown-toggle"><i class="bi bi-three-dots-vertical"></i></button>
                    <ul class="dropdown-menu-left">
                        <li><a class="dropdown-item" href="/">Home</a></li>
                        <li><a class="dropdown-item" href="/favorites">Favorites</a></li>
                        <li><a class="dropdown-item" href="/Listings/page/profile/1">View My Listings</a></li>
                        <li><a class="dropdown-item" href="/Listings/page/create">Create a Listing</a></li>
                    </ul>
                </div>
            </li>

            <li class="nav-item ms-3">
                <img src="/high-fidelity-prototype/images/Logo.jpg" width="100" height="50">
            </li>
        </ul>

        <div class="ms-auto">
            <div class="dropdown">
                <button class="dropdown-toggle">
                    <img src="/high-fidelity-prototype/images/default user.jpg"
                         class="rounded-circle" width="40" height="40">
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


<div class="details-and-carousel">

    <!-- IMAGE CAROUSEL -->
    <div class="image-section" style="padding: 20px;">
        <div class="image-carousel-view">

            <div class="slides-listing">
                <#if images?size == 0>
                    <img src="/images/placeholder.jpg" class="listing-thumb">
                <#else>
                    <#list images as img>
                        <img src="${img.imagePath}" class="listing-thumb">
                    </#list>
                </#if>
            </div>

        </div>
    </div>


    <!-- LISTING DETAILS -->
    <form class="listing-form">

        <div class="form-header">
            <h1>${listing.name}</h1>
        </div>

        <div class="form-details">
            <h2>Location</h2>
            <span>${listing.address}, ${listing.city}, ${listing.state} ${listing.zipCode}</span>
        </div>

        <div class="form-details">
            <h2>Description</h2>
            <span>${listing.description}</span>
        </div>

        <div class="form-details">
            <h2>Price Per Night</h2>
            <span>$${listing.pricePerNight}</span>
        </div>

        <div class="form-details">
            <h2>Rules</h2>
            <span>${listing.rules!""}</span>
        </div>

        <div class="form-section date-inputs">
            <div class="date-group">
                <label>Check-in:</label>
                <input type="date">
            </div>
            <div class="date-group">
                <label>Check-out:</label>
                <input type="date">
            </div>
        </div>

        <a class="checkout-button" href="/checkout">
            Book Now
        </a>

    </form>
</div>


<!-- OPTIONAL Reviews Section (Static for now) -->
<div class="comments-section">
    <h2>Reviews</h2>
    <p style="color:white;">(Reviews coming soon...)</p>
</div>

<script src="/high-fidelity-prototype/scripting/navBar.js"></script>
</body>
</html>
