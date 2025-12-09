<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Listings</title>
    <link rel="stylesheet" href="/css/global.css">
    <link rel="stylesheet" href="/css/navbar.css">
    <link rel="stylesheet" href="/css/my-listings.css">
    <link rel="stylesheet" href="/css/listings.css" />
</head>

<body>
    <#include "navbar.ftlh" />
    
    <h1 style="text-align:center;">My Listings</h1>

    <!-- USER'S LISTINGS SECTION -->
    <h2 class="section-title">Your Listings</h2>

    <div class="listing-grid">

        <#if listings?size == 0>
            <p style="text-align:center; color:white;">You have no listings yet.</p>
        </#if>

        <#list listings as listing>
            <div class="listing-card"
                 id="listing-${listing.id}"
                 onclick="filterBookings(${listing.id})">

                <#assign key = listing.id?string />
                <#assign imgs = listingImagesMap[key]![] />

                <#if imgs?has_content>
                    <#assign imgPath = imgs[0].imagePath />
                <#else>
                    <#assign imgPath = "/images/placeholder.jpg" />
                </#if>

                <img src="${imgPath}" class="listing-thumb" />


                <div class="listing-info">
                    <h3>${listing.name}</h3>
                    <p>${listing.city}, ${listing.state}</p>

                    <p><strong>$${listing.pricePerNight}</strong> / night</p>

                    <a class="view-btn" href="/listing/${listing.id}">View</a>
                    <a class="view-btn" href="/listing/${listing.id}/edit">Edit</a>
                </div>

            </div>
        </#list>

    </div>

    <br/><br/>

    <!-- BUTTON TO RESET FILTER -->
    <div style="text-align:center;">
        <button onclick="filterBookings('ALL')" style="padding:10px 20px; font-size:16px;">
            Show All Bookings
        </button>
    </div>

   <!-- BOOKINGS TABLE SECTION -->
    <h2 class="section-title">Bookings for Your Listings</h2>

    <table>
        <thead>
            <tr>
                <th>Booking ID</th>
                <th>Listing</th>
                <th>Guest</th>
                <th>Check-In</th>
                <th>Check-Out</th>
                <th>Total Price</th>
            </tr>
        </thead>

        <tbody>
        <#if bookings?size == 0>
            <tr>
                <td colspan="6" style="text-align:center;">No bookings found.</td>
            </tr>
        </#if>

        <#list bookings as b>
            <tr class="booking-row" data-listing-id="${b.listing.id}">
                <td>${b.id}</td>
                <td>${b.listing.name}</td>
                <td>${b.profile.username}</td>
                <td>${b.startDate}</td>
                <td>${b.endDate}</td>
                <td>$${b.totalPrice}</td>
            </tr>
        </#list>
        </tbody>
    </table>
    <script src="/scripting/myListings.js"></script>
</body>
</html>
