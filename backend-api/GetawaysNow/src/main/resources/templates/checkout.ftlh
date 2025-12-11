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
            <p>Price per night: <strong>$${listing.pricePerNight}</strong></p>

            <input type="hidden" name="profileId" value="${profileId}">
            <input type="hidden" name="listingId" value="${listingId}">

            <label for="startDate">Check-in Date</label>
            <input type="date" id="startDate" name="startDate">

            <label for="endDate">Check-out Date</label>
            <input type="date" id="endDate" name="endDate">

            <div id="price-summary"
                style="margin: 20px 0; padding: 10px; background-color: #f8f9fa; border-radius: 5px; display: none;">
                <h4>Total Price: <span id="total-price-display">$0.00</span></h4>
                <small id="nights">0 nights</small>
            </div>

            <button type="submit" class="confirm-btn" style="background-color: hsl(216, 100%, 50%); color: white;">
                Confirm Booking
            </button>
        </form>

        <!-- Carousel -->
        <div class="carousel-box" style="flex: 1;">
            <div class="carousel" style="position: relative; overflow: hidden; height: 800px;">
                <div class="slides" id="checkout-slides" style="display: flex; transition: transform 0.3s ease;">

                    <#if images?has_content>
                        <img src="${images[0].imagePath}" style="width:100%; object-fit:cover;">
                        <#else>
                            <img src="/images/placeholder.jpg" style="width:100%; object-fit:cover;">
                    </#if>

                </div>
            </div>
        </div>


        <script>
            const pricePerNight = ${ listing.pricePerNight };
            const startInput = document.getElementById('startDate');
            const endInput = document.getElementById('endDate');
            const priceDisplay = document.getElementById('total-price-display');
            const nightCountDisplay = document.getElementById('nights');
            const summaryBox = document.getElementById('price-summary');

            function calculateTotal() {
                const startVal = startInput.value;
                const endVal = endInput.value;

                if (startVal && endVal) {
                    const date1 = new Date(startVal);
                    const date2 = new Date(endVal);

                    const diffTime = date2 - date1;
                    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

                    if (diffDays > 0) {
                        const total = diffDays * pricePerNight;

                        priceDisplay.textContent = "$" + total.toFixed(2);
                        nightCountDisplay.textContent = diffDays + " nights x $" + pricePerNight;
                        summaryBox.style.display = "block";
                    } else {
                        summaryBox.style.display = "none";
                    }

                }
            }
            startInput.addEventListener('change', calculateTotal);
            endInput.addEventListener('change', calculateTotal);
        </script>
</body>

</html>