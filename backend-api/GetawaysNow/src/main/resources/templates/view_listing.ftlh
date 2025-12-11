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
            <div class="listing-form">
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
                <form action="/checkout/listing/${listing.id}" method="GET">
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
        </div>

    </section>

   <!-- BOTTOM: REVIEWS -->
    <section class="comments-section">
        <h2>Reviews</h2>

        <!-- Guest Review Form -->
        <div class="add-comment-form">
            <h3 class="add-comment-heading">Leave a Review</h3>

            <form action="/reviews/add" method="POST">
                <input type="hidden" name="listingId" value="${listing.id}">

                <div class="form-group">
                    <label style="color:black;">Your Review</label>
                    <textarea name="comment" rows="4" required></textarea>
                </div>

                <button type="submit" class="submit-comment-button">Submit Review</button>
            </form>
        </div>


        <!-- Reviews List -->
        <div class="comments-list">
            <h3>User Reviews</h3>

            <#if reviews?size == 0>
                <p>No reviews yet.</p>
            <#else>
                <#list reviews as review>
                    <div class="comment">

                        <strong>${review.profile.username}</strong>
                        <p>${review.comment}</p>

                        <#if listing.profileID?? 
                            && listing.profileID.id?? 
                            && session.profileId?? 
                            && (listing.profileID.id == session.profileId)>
                            
                            <form action="/reviews/reply" method="POST" class="reply-form">
                                <input type="hidden" name="listingId" value="${listing.id}">
                                <input type="hidden" name="parentId" value="${review.id}">
                                
                                <textarea name="comment" rows="2" placeholder="Reply to this review..." required></textarea>
                                <button type="submit">Reply</button>
                            </form>

                        </#if>

                    </div>
                </#list>
            </#if>
        </div>
    </section>



</main>

<!-- JS -->
<script src="/scripting/viewListing.js"></script>

</body>
</html>
