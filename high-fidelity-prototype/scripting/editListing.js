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

  // --- Populate the form directly with the data above ---
  document.getElementById('name').value = listingToDisplay.title;
  document.getElementById('address').value = listingToDisplay.location;
  document.getElementById('desc').value = listingToDisplay.description;
  document.getElementById('Price').value = parseInt(listingToDisplay.price);
  document.getElementById('rules').value = listingToDisplay.rules;
  
  // Populate the image preview carousel
  const previewSlides = document.getElementById('preview-slides');
  previewSlides.innerHTML = ''; 

  listingToDisplay.images.forEach(imageUrl => {
    const slide = document.createElement('div');
    slide.classList.add('slide');
    slide.style.backgroundImage = `url('${imageUrl}')`;
    previewSlides.appendChild(slide);
  });
});

// --- NEW CAROUSEL NAVIGATION LOGIC ---

function updateCarouselPosition() {
  const slidesContainer = document.getElementById("preview-slides");
  const offset = -currentSlideIndex * 100; // Move by 100% of the container width
  slidesContainer.style.transform = `translateX(${offset}%)`;
}

function nextPreviewSlide() {
  const slideCount = document.querySelectorAll(".slides-listing .slide").length;
  if (slideCount === 0) return;
  // Move to the next slide, looping back to the start if at the end
  currentSlideIndex = (currentSlideIndex + 1) % slideCount;
  updateCarouselPosition();
}

function prevPreviewSlide() {
  const slideCount = document.querySelectorAll(".slides-listing .slide").length;
  if (slideCount === 0) return;
  // Move to the previous slide, looping to the end if at the start
  currentSlideIndex = (currentSlideIndex - 1 + slideCount) % slideCount;
  updateCarouselPosition();
}