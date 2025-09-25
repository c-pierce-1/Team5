

// Rental data
const rentals = [
  {
    title: "Cozy Cabin",
    location: "1286 East Bend NC",
    description: "Cozy cabin located just on the top of a mountain with a cozy view.",
    price: "$180/night",
    images: ["/high-fidelity-prototype/images/CozyCabins1.jpg", "/high-fidelity-prototype/images/CozyCabins2.jpg", "/high-fidelity-prototype/images/CozyCabins3.jpg"]
  },
  {
    title: "Mountain Escape",
    location: "Blue Ridge Parkway",
    description: "A peaceful retreat with panoramic views.",
    price: "$220/night",
    images: ["/high-fidelity-prototype/images/mountain1.jpg", "/high-fidelity-prototype/images/mountain2.jpg", "/high-fidelity-prototype/images/mountain3.jpg"]
  }
];

// Track slide index per carousel
const slideIndices = {};

// Create carousel HTML
function createCarousel(rental, index) {
  const slideId = `slides-${index}`;
  const slides = rental.images.map(img =>
    `<a href="/high-fidelity-prototype/customer-prototype/view_listing.html" class="slide" style="background-image: url('${img}')"></a>`
  ).join("");

  return `
    <div class="carousel-wrapper">
      <div class="carousel">
        <div class="slides" id="${slideId}">${slides}</div>
        <div class="nav">
          <button onclick="prevSlide('${slideId}')">❮</button>
          <button onclick="nextSlide('${slideId}')">❯</button>
        </div>
      </div>

      <div class="info-box" style="position: relative;">
        <button 
          class="edit-btn" 
          style="
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: #88b6c8;
            color: white;
            border: none;
            padding: 0.5rem 1rem;
            border-radius: 6px;
            cursor: pointer;
          "
          onclick="window.location.href='/high-fidelity-prototype/provider-prototype/edit_listing.html'"
        >
          Edit
        </button>

        <h1>${rental.title}</h1>
        <p>${rental.location}</p>
        <p>${rental.description}</p>
      </div>
    </div>
  `;
}

// Render all carousels
document.addEventListener("DOMContentLoaded", () => {
  const container = document.getElementById("carousel-container");
  container.innerHTML = rentals.map((rental, i) => {
    slideIndices[`slides-${i}`] = 0;
    return createCarousel(rental, i);
  }).join("");
});

// Slide navigation
function showSlide(id, index) {
  const slides = document.getElementById(id);
  slides.style.transform = `translateX(-${index * 100}%)`;
}

function nextSlide(id) {
  const total = document.getElementById(id).children.length;
  slideIndices[id] = (slideIndices[id] + 1) % total;
  showSlide(id, slideIndices[id]);
}

function prevSlide(id) {
  const total = document.getElementById(id).children.length;
  slideIndices[id] = (slideIndices[id] - 1 + total) % total;
  showSlide(id, slideIndices[id]);
}

