
function filterBookings(listingId) {
    const rows = document.querySelectorAll(".booking-row");

    rows.forEach(r => {
        if (listingId === "ALL" || r.dataset.listingId === listingId.toString()) {
            r.style.display = "";
        } else {
            r.style.display = "none";
        }
    });

    // Remove highlight from all listing cards
    const cards = document.querySelectorAll(".listing-card");
    cards.forEach(c => c.classList.remove("selected"));

    // Highlight selected listing card
    if (listingId !== "ALL") {
        const selected = document.getElementById("listing-" + listingId);
        if (selected) selected.classList.add("selected");
    }
}
