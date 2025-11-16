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
    <nav class="navbar">
        <div class="container-fluid">
            <ul class="navbar-nav flex-row align-items-center">
                <li class="nav-item">
                    <ul class="dropdown-menu-left">
                        <li><a class="dropdown-item" href="/">Home</a></li>
                        <li><a class="dropdown-item" href="/profile/${profileId}/favorites">Favorites</a></li>
                        <li><a class="dropdown-item" href="/profile/${profileId}/listings">View My Listings</a></li>
                    </ul>
                </li>

                <li class="nav-item ms-3">
                    <img src="/images/Logo.jpg" alt="Logo" width="100" height="50" />
                </li>
            </ul>

            <!-- Profile dropdown -->
            <div class="ms-auto">
                <div class="dropdown">
                    <button class="dropdown-toggle">
                        <img src="/images/default user.jpg" alt="Profile" class="rounded-circle" width="40"
                            height="40" />
                    </button>
                    <ul class="dropdown-menu-right">
                        <li><a class="dropdown-item" href="/profile/${profileId}">My Profile</a></li>
                        <li><a class="dropdown-item" href="/login">Login</a></li>
                        <li><a class="dropdown-item" href="/logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>

    <div class="checkout-container" style="display: flex; gap: 2rem; margin: 2rem;">

        <form class="booking-box" style="flex: 1;" action="/booking/create" method="POST">

            <h2>Check-Out</h2>

            <input type="hidden" name="profileId" value="${profileId}">
            <input type="hidden" name="listingId" value="${listingId}">

            <label for="startDate">Check-in Date</label>
            <input type="date" id="startDate" name="startDate">

            <label for="endDate">Check-out Date</label>
            <input type="date" id="endDate" name="endDate">

            <label for="totalPrice">Total</label>
            <input type="number" id="totalPrice" name="totalPrice" step="0.01" placeholder="e.g., 590.80">

            <button type="submit" class="confirm-btn" style="background-color: hsl(216, 100%, 50%); color: white;">
                Confirm Booking
            </button>
        </form>

        <!-- Carousel -->
        <div class="carousel-box" style="flex: 1;">
            <div class="carousel" style="position: relative; overflow: hidden; height: 800px;">
                <div class="slides" id="checkout-slides" style="display: flex; transition: transform 0.3s ease;">
                    <img src="/high-fidelity-prototype/images/CozyCabins1.jpg" style="width:100%; object-fit:cover;">
                </div>
</body>
<script src="/scripting/script.js"></script>
<script src="/scripting/navBar.js"></script>

</html>