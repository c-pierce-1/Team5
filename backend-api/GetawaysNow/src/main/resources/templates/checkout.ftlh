<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>checkout</title>
    <link rel="stylesheet" href="/Style-Sheet.css" />
    <!-- Bootstrap Icons for the three dots -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" />
</head>

<body>
    <#include "navbar.ftlh" />

    <div class="checkout-container" style="display: flex; gap: 2rem; margin: 2rem;">

        <form class="booking-box" style="flex: 1;" action="/booking/create" method="POST">

            <h2>Check-Out</h2>

            <input type="hidden" name="profileId" value="${profileId}">
            <input type="hidden" name="listingId" value="${listingId}">

            <label for="startDate">Check-in Date</label>
            <input type="date" id="startDate" name="startDate">

            <label for="endDate">Check-out Date</label>
            <input type="date" id="endDate" name="endDate">

            <button type="submit" class="confirm-btn" style="background-color: hsl(216, 100%, 50%); color: white;">
                Confirm Booking
            </button>
        </form>

        <!-- Carousel -->
        <div class="carousel-box" style="flex: 1;">
            <div class="carousel" style="position: relative; overflow: hidden; height: 800px;">
                <div class="slides" id="checkout-slides" style="display: flex; transition: transform 0.3s ease;">
                    <img src="/CozyCabins1.jpg" style="width:100%; object-fit:cover;">
                </div>
</body>

</html>