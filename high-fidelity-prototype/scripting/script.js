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
    `<a href="/high-fidelity-prototype/customer-prototype/listing.html" class="slide" style="background-image: url('${img}')"></a>`
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

    <div class="info-box">
        <h1>${rental.title}</h1>
        <p>${rental.location}</p>
        <p>${rental.description}</p>
        <button class="price-button" onclick="window.location.href='/high-fidelity-prototype/customer-prototype/listing/${rental.title.replace(/\s+/g, '-').toLowerCase()}.html'">
        ${rental.price}
        </button>
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

// Search logic (optional)
function handleSearch() {
  const query = document.getElementById('search-bar').value.toLowerCase();
  const filtered = rentals.filter(rental =>
    rental.title.toLowerCase().includes(query) ||
    rental.location.toLowerCase().includes(query) ||
    rental.description.toLowerCase().includes(query)
  );

  const container = document.getElementById("carousel-container");
  container.innerHTML = filtered.map((rental, i) => {
    slideIndices[`slides-${i}`] = 0;
    return createCarousel(rental, i);
  }).join("");
}

document.querySelectorAll('.info-row').forEach(row => {
  const editBtn = row.querySelector('.edit-btn');
  const saveBtn = row.querySelector('.save-btn');
  const span = row.querySelector('.value');
  const input = row.querySelector('.edit-input');

  editBtn.addEventListener('click', () => {
    input.value = span.textContent;
    span.style.display = 'none';
    input.style.display = 'inline-block';
    editBtn.style.display = 'none';
    saveBtn.style.display = 'inline-block';
  });

  saveBtn.addEventListener('click', () => {
    span.textContent = input.value;
    span.style.display = 'inline-block';
    input.style.display = 'none';
    editBtn.style.display = 'inline-block';
    saveBtn.style.display = 'none';
  });
});