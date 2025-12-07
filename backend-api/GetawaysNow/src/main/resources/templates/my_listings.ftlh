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

                <img src="/images/placeholder.jpg" class="listing-thumb"/>

                <div class="listing-info">
                    <h3>${listing.name}</h3>
                    <p>${listing.city}, ${listing.state}</p>

                    <p><strong>$${listing.pricePerNight}</strong> / night</p>

                    <a class="view-btn" href="/Listings/page/${listing.id}">View</a>
                    <a class="view-btn" href="/Listings/page/edit/${listing.id}">Edit</a>
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
                <th>Status</th>
            </tr>
        </thead>

        <tbody>
        <#if bookings?size == 0>
            <tr>
                <td colspan="6" style="text-align:center;">No bookings found.</td>
            </tr>
        </#if>

        <#list bookings as b>
            <tr class="booking-row" data-listing-id="${b.listingId}">
                <td>${b.id}</td>
                <td>${b.listingName}</td>
                <td>${b.guestName}</td>
                <td>${b.startDate}</td>
                <td>${b.endDate}</td>
                <td>${b.status}</td>
            </tr>
        </#list>
        </tbody>
    </table>

    <script src="/scripting/navBar.js"></script>
    <script src="/scripting/myListings.js"></script>
</body>
</html>
