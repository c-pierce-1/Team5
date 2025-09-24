// Dropdown logic
document.querySelectorAll('.dropdown-toggle').forEach(button => {
    button.addEventListener('click', () => {
        const parent = button.closest('.dropdown');
        parent.classList.toggle('open');
    });
});

window.addEventListener('click', (e) => {
    if (!e.target.closest('.dropdown')) {
        document.querySelectorAll('.dropdown').forEach(drop => drop.classList.remove('open'));
    }
});

// Rental data
const rentals = [
    {
        title: "Cozy Cabin",
        location: "1286 East Bend NC",
        description: "Cozy cabin located just on the top of a mountain with a cozy view.",
        price: "$180/night",
        images: ["/high-fidelity-prototype/images/CozyCabins1.jpg", "/high-fidelity-prototype/images/CozyCabins2.jpg", "/high-fidelity-prototype/images/CozyCabins3.jpg"]
    }
];

// Track slide index per carousel
const slideIndices = {};

// Create carousel HTML
function createCarousel(rental, index, size = "normal") {
    const slideId = `slides-${index}`;
    const slides = rental.images.map(img =>
        `<a href="/high-fidelity-prototype/customer-prototype/view_listing.html" class="slide" style="background-image: url('${img}')"></a>`
    ).join("");

    const cardClass = size === "large" ? "carousel-wrapper large-card" : "carousel-wrapper";

    return `
    <div class="${cardClass}">
      <div class="carousel">
        <div class="slides" id="${slideId}">${slides}</div>
        <div class="nav">
          <button onclick="prevSlide('${slideId}')">❮</button>
          <button onclick="nextSlide('${slideId}')">❯</button>
        </div>
      </div>

  `;
}

// Render large carousel
document.addEventListener("DOMContentLoaded", () => {
    const container = document.getElementById("carousel-container");
    container.innerHTML = rentals.map((rental, i) => {
        slideIndices[`slides-${i}`] = 0;
        return createCarousel(rental, i, "large");
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

