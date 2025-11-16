<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${listing.name}</title>

    <!-- GLOBAL + VIEW CSS -->
    <link rel="stylesheet" href="/high-fidelity-prototype/Style-Sheet.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
</head>

<body>

<!-- NAV BAR -->
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
                        <li><a class="dropdown-item" href="/listings/page/profile/1">View My Listings</a></li>
                        <li><a class="dropdown-item" href="/listings/page/create">Create a Listing</a></li>
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



<!-- MAIN CONTENT LAYOUT -->
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

            <!-- Arrows -->
            <div class="nav">
                <button onclick="prevSlide()">❮</button>
                <button onclick="nextSlide()">❯</button>
            </div>

        </div>
    </div>



    <!-- LISTING DETAILS FORM -->
    <div class="listing-form">

        <div class="form-header">
            <h1>${listing.name}</h1>
        </div>

        <!-- LOCATION -->
        <div class="form-details">
            <h2>Location</h2>
            <span>
                ${listing.address}<br>
                ${listing.city}, ${listing.state} ${listing.zipCode}
            </span>
        </div>

        <!-- BED / BATH -->
        <div class="form-details">
            <h2>Bed & Bath</h2>
            <span>
                ${listing.bedrooms} Bedrooms • ${listing.bathrooms} Bathrooms
            </span>
        </div>

        <!-- DESCRIPTION -->
        <div class="form-details">
            <h2>Description</h2>
            <span>${listing.description}</span>
        </div>

        <!-- PRICE -->
        <div class="form-details">
            <h2>Price Per Night</h2>
            <span>$${listing.pricePerNight}</span>
        </div>

        <!-- RULES -->
        <div class="form-details">
            <h2>Rules</h2>
            <span>${listing.rules!""}</span>
        </div>

        <!-- CHECK-IN / CHECK-OUT -->
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

        <!-- BUTTON -->
        <a class="checkout-button" href="/checkout">
            Book Now
        </a>

    </div>
</div>



<!-- Reviews Section -->
<div class="comments-section">
    <h2>Reviews</h2>
    <p style="color:white;">(Reviews coming soon...)</p>
</div>

<script src="/high-fidelity-prototype/scripting/navBar.js"></script>
<script>
    let slideIndex = 0;
    const slides = document.querySelectorAll(".slides-listing img");

    function showSlide(n) {
        slides.forEach(img => img.style.display = "none");
        slides[n].style.display = "block";
    }

    function nextSlide() {
        slideIndex = (slideIndex + 1) % slides.length;
        showSlide(slideIndex);
    }

    function prevSlide() {
        slideIndex = (slideIndex - 1 + slides.length) % slides.length;
        showSlide(slideIndex);
    }

    showSlide(0);
</script>

</body>
</html>
