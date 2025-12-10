<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>${listing.name}</title>

    <link rel="stylesheet" href="/css/global.css" />
    <link rel="stylesheet" href="/css/view-listing.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" />
</head>
<body>

<#include "navbar.ftlh" />

<main>

    <!-- TOP: IMAGES (LEFT) + DETAILS (RIGHT) -->
    <section class="details-and-carousel">

        <!-- LEFT: IMAGE CAROUSEL -->
        <div class="image-section">
            <div class="image-carousel-view">
                <div class="slides-listing" id="preview-slides">
                    <#if images?has_content>
                        <#list images as img>
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
                    <form action="/favorite/add" method="POST" style="display:inline;">
                        <input type = "hidden" name="listingId" value="${listing.id}">
                        <button type = "submit" class="favorite-icon-btn" style="background:none; border:none; cursor:pointer;">
                            <i class="bi bi-heart" style="font-size: 1.5rem; color: red;"></i>
                        </button>
                    </form>
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
                    <a style="color: inherit; text-decoration: none;" href="/checkout/listing/${listing.id}">Book Now</a>
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
<script src="/scripting/viewListing.js"></script>

</body>
</html>
