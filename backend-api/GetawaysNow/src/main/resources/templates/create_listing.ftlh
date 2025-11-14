<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create Listing</title>
    <link rel="stylesheet" href="/high-fidelity-prototype/Style-Sheet.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" />
</head>

<body>

<!-- NAV BAR -->
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
            </div>
        </div>

    </div>
</nav>

<div class="form-and-carousel">

    <form method="post" action="/Listings/page/create" class="listing-form-container">

        <div class="form-header">
            <h1>Create Listing</h1>
        </div>

        <!-- NAME -->
        <div class="form-group">
            <label>Name:</label>
            <input type="text" name="name" required />
        </div>

        <!-- ADDRESS -->
        <div class="form-group">
            <label>Address:</label>
            <input type="text" name="address" required />
        </div>

        <!-- CITY -->
        <div class="form-group">
            <label>City:</label>
            <input type="text" name="city" required />
        </div>

        <!-- STATE -->
        <div class="form-group">
            <label>State:</label>
            <input type="text" name="state" required />
        </div>

        <!-- ZIP -->
        <div class="form-group">
            <label>Zip Code:</label>
            <input type="text" name="zipCode" required />
        </div>

        <!-- DESCRIPTION -->
        <div class="form-group">
            <label>Description:</label>
            <textarea name="description" rows="4" required></textarea>
        </div>

        <!-- PRICE -->
        <div class="form-group">
            <label>Price per Night:</label>
            <input type="number" name="pricePerNight" required />
        </div>

        <!-- BEDROOMS -->
        <div class="form-group">
            <label>Bedrooms:</label>
            <input type="number" name="bedrooms" required />
        </div>

        <!-- BATHROOMS -->
        <div class="form-group">
            <label>Bathrooms:</label>
            <input type="number" step="0.1" name="bathrooms" required />
        </div>

        <!-- RULES -->
        <div class="form-group">
            <label>Rules:</label>
            <textarea name="rules" rows="3"></textarea>
        </div>

        <button type="submit" id="submit-btn">Save Listing</button>

    </form>
</div>

</body>
</html>
