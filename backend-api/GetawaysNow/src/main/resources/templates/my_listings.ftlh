<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Listings</title>

    <link rel="stylesheet" href="/high-fidelity-prototype/Style-Sheet.css">
</head>

<body>

<h1 style="text-align:center;">My Listings</h1>

<div class="listing-grid">

    <#if listings?size == 0>
        <p style="text-align:center; color:white;">You have no listings yet.</p>
    </#if>

    <#list listings as listing>
        <div class="listing-card">

            <img src="/images/placeholder.jpg" class="listing-thumb"/>

            <div class="listing-info">
                <h3>${listing.name}</h3>
                <p>${listing.city}, ${listing.state}</p>

                <p>
                    <strong>$${listing.pricePerNight}</strong> / night
                </p>

                <a class="view-btn" href="/Listings/page/${listing.id}">View</a>
                <a class="view-btn" href="/Listings/page/edit/${listing.id}">Edit</a>

            </div>

        </div>
    </#list>

</div>

</body>
</html>
