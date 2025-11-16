// File: /high-fidelity-prototype/scripting/editListing.js

// --- Global variable to track the current slide index ---
let currentSlideIndex = 0;

document.addEventListener('DOMContentLoaded', () => {
    // --- Hard-coded data for one specific listing ---
    const listingToDisplay = {
        title: "Cozy Cabin",
        location: "1286 East Bend NC",
        description: "Cozy cabin located just on the top of a a mountain with a cozy view.",
        price: 180,
        rules: "No pets allowed. No smoking inside. Please respect the neighbors.",
        images: [
            "/high-fidelity-prototype/images/CozyCabins1.jpg",
            "/high-fidelity-prototype/images/CozyCabins2.jpg",
            "/high-fidelity-prototype/images/CozyCabins3.jpg"
        ]
    };

    // --- Populate the display labels directly with the data above ---
    document.getElementById('name-label').innerText = listingToDisplay.title;
    document.getElementById('address-label').innerText = listingToDisplay.location;
    document.getElementById('desc-label').innerText = listingToDisplay.description;
    document.getElementById('price-label').innerText = `$${listingToDisplay.price}`;
    document.getElementById('rules-label').innerText = listingToDisplay.rules;

    // --- Populate the image preview carousel from the hard-coded data ---
    const previewSlides = document.getElementById('preview-slides');
    previewSlides.innerHTML = '';

    listingToDisplay.images.forEach(imageUrl => {
        const slide = document.createElement('div');
        slide.classList.add('slide');
        slide.style.backgroundImage = `url('${imageUrl}')`;
        previewSlides.appendChild(slide);
    });

    // Initial positioning of the carousel
    updateCarouselPosition();
});

// --- CAROUSEL NAVIGATION LOGIC ---

function updateCarouselPosition() {
    const slidesContainer = document.getElementById("preview-slides");
    const offset = -currentSlideIndex * 100;
    slidesContainer.style.transform = `translateX(${offset}%)`;
}

function nextPreviewSlide() {
    const slideCount = document.querySelectorAll(".slides-listing .slide").length;
    if (slideCount === 0) return;
    currentSlideIndex = (currentSlideIndex + 1) % slideCount;
    updateCarouselPosition();
}

function prevPreviewSlide() {
    const slideCount = document.querySelectorAll(".slides-listing .slide").length;
    if (slideCount === 0) return;
    currentSlideIndex = (currentSlideIndex - 1 + slideCount) % slideCount;
    updateCarouselPosition();
}


document.addEventListener('DOMContentLoaded', function() {
    const favoriteIcon = document.getElementById('favorite-icon');

    if (favoriteIcon) {
        // Add a click event listener to the icon
        favoriteIcon.addEventListener('click', function() {
            if (favoriteIcon.classList.contains('bi-heart-fill')) {
                favoriteIcon.classList.remove('bi-heart-fill');
                favoriteIcon.classList.add('bi-heart');
                console.log('Un-favorited!');
            } else {
                // If it's empty, fill it in
                favoriteIcon.classList.remove('bi-heart');
                favoriteIcon.classList.add('bi-heart-fill');
                console.log('Favorited!');
            }
        });
    }
});