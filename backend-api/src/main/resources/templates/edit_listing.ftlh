<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit ${listing.name}</title>

    <link rel="stylesheet" href="/high-fidelity-prototype/Style-Sheet.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
</head>

<body>

<nav class="navbar">
    <div class="container-fluid">
        <ul class="navbar-nav flex-row align-items-center">
            <li class="nav-item">
                <div class="dropdown">
                    <button class="dropdown-toggle"><i class="bi bi-three-dots-vertical"></i></button>
                    <ul class="dropdown-menu-left">
                        <li><a class="dropdown-item" href="/">Home</a></li>
                        <li><a class="dropdown-item" href="/Listings/page/profile/1">View My Listings</a></li>
                        <li><a class="dropdown-item" href="/Listings/page/create">Create Listing</a></li>
                    </ul>
                </div>
            </li>

            <li class="nav-item ms-3">
                <img src="/high-fidelity-prototype/images/Logo.jpg" width="100" height="50">
            </li>
        </ul>
    </div>
</nav>


<div class="form-and-carousel">

    <form method="post" action="/Listings/page/edit/${listing.id}" class="listing-form-container">

        <div class="form-header">
            <h1>Edit Listing</h1>
        </div>

        <input type="hidden" name="id" value="${listing.id}" />

        <div class="form-group">
            <label>Name:</label>
            <input type="text" name="name" value="${listing.name}" required />
        </div>

        <div class="form-group">
            <label>Address:</label>
            <input type="text" name="address" value="${listing.address}" required />
        </div>

        <div class="form-group">
            <label>City:</label>
            <input type="text" name="city" value="${listing.city}" required />
        </div>

        <div class="form-group">
            <label>State:</label>
            <input type="text" name="state" value="${listing.state}" required />
        </div>

        <div class="form-group">
            <label>Zip:</label>
            <input type="text" name="zipCode" value="${listing.zipCode}" required />
        </div>

        <div class="form-group">
            <label>Description:</label>
            <textarea name="description" rows="4">${listing.description}</textarea>
        </div>

        <div class="form-group">
            <label>Price Per Night:</label>
            <input type="number" name="pricePerNight" value="${listing.pricePerNight}" required />
        </div>

        <div class="form-group">
            <label>Bedrooms:</label>
            <input type="number" name="bedrooms" value="${listing.bedrooms}" required />
        </div>

        <div class="form-group">
            <label>Bathrooms:</label>
            <input type="number" step="0.1" name="bathrooms" value="${listing.bathrooms}" required />
        </div>

        <div class="form-group">
            <label>Rules:</label>
            <textarea name="rules" rows="3">${listing.rules!""}</textarea>
        </div>

        <button type="submit">Save Changes</button>

    </form>
</div>

</body>
</html>
