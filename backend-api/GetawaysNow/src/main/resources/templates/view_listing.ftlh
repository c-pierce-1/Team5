<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>${listing.name}</title>

    <link rel="stylesheet" href="/css/global.css" />
    <link rel="stylesheet" href="/css/navbar.css" />
    <link rel="stylesheet" href="/css/view-listing.css" />
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

        <div class="ms-auto">
            <div class="dropdown">
                <button class="dropdown-toggle">
                    <img src="/images/defaultuser.jpg"
                         alt="Profile"
                         class="rounded-circle"
                         width="40"
                         height="40" />
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

<main>

    <!-- TOP: IMAGES (LEFT) + DETAILS (RIGHT) -->
    <section class="details-and-carousel">

        <!-- LEFT: IMAGE CAROUSEL -->
        <div class="image-section">
            <div class="image-carousel-view">
                <div class="slides-listing" id="preview-slides">
                    <#if images?has_content>
                        <#list images as img>
                            <!-- imagePath should already be like /uploads/xyz.jpg -->
                            <div class="slide" style="background-image: url('${img.imagePath}');"></div>
                        </#list>
                    <#else>
                        <!-- No images: show placeholder -->
                        <div class="slide" style="background-image: url('/images/placeholder.jpg');"></div>
                    </#if>
                </div>

                <!-- Carousel buttons (left/right) -->
                <button type="button" class="carousel-btn left" onclick="prevPreviewSlide()">❮</button>
                <button type="button" class="carousel-btn right" onclick="nextPreviewSlide()">❯</button>

            </div>
        </div>

        <!-- RIGHT: BLUE DETAILS CARD -->
        <div class="details-box">
            <form class="listing-form" action="#" method="POST">
                <div class="form-header">
                    <h1>${listing.name}</h1>
                    <span id="favorite-icon" class="favorite-icon-btn bi bi-heart"></span>
                </div>

                <div class="form-details">
                    <h2>Location</h2>
                    <span>
                        ${listing.address}<br />
                        ${listing.city}, ${listing.state} ${listing.zipCode}
                    </span>
                </div>

                <div class="form-details">
                    <h2>Description</h2>
                    <span>${listing.description!""}</span>
                </div>

                <div class="form-details">
                    <h2>Bed &amp; Bath</h2>
                    <span>${listing.bedrooms} Bedrooms • ${listing.bathrooms} Bathrooms</span>
                </div>

                <div class="form-details">
                    <h2>Price Per Night</h2>
                    <span class="price">$${listing.pricePerNight}</span>
                </div>

                <div class="form-details">
                    <h2>Rules</h2>
                    <span>${listing.rules!""}</span>
                </div>

                <div class="form-section date-inputs">
                    <div class="date-group">
                        <label>Check-in:</label>
                        <input type="date" name="checkIn">
                    </div>
                    <div class="date-group">
                        <label>Check-out:</label>
                        <input type="date" name="checkOut">
                    </div>
                </div>

                <button class="checkout-button" type="button">
                    <a style="color: inherit; text-decoration: none;" href="/checkout">Book Now</a>
                </button>
            </form>
        </div>

    </section>

    <!-- BOTTOM: REVIEWS -->
    <section class="comments-section">
        <h2>Reviews</h2>

        <div class="add-comment-form">
            <h3 class="add-comment-heading">Leave a comment</h3>
            <form>
                <div class="form-group">
                    <label style="color:black;">Your Name</label>
                    <input type="text" required>
                </div>

                <div class="form-group">
                    <label style="color:black;">Your Comment</label>
                    <textarea rows="4" required></textarea>
                </div>

                <button type="submit" class="submit-comment-button">Submit Comment</button>
            </form>
        </div>

        <div class="comments-list">
            <h3>User Comments</h3>
            <p>No comments yet.</p>
        </div>
    </section>

</main>

<!-- JS -->
<script src="/scripting/navBar.js"></script>
<script src="/scripting/viewListing.js"></script>

</body>
</html>
