// File: /high-fidelity-prototype/scripting/editListing.js

// --- Global variable to track the current slide index ---
let currentSlideIndex = 0;
// --- Global variable to hold the list of all images (URLs and files) ---
let selectedFiles = [];

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
  
  // --- Initialize the selectedFiles array with hard-coded images ---
  selectedFiles = listingToDisplay.images.map(url => ({
    url: url,
    name: url.split('/').pop(), // Give it a name for uniqueness check
    isNew: false // Flag to distinguish from new uploads
  }));
  
  // Get the file input and upload zone for drag-and-drop
  const uploadZone = document.getElementById("upload-zone");
  const fileInput = document.getElementById("images");

  // --- Drag and Drop Logic ---
  uploadZone.addEventListener("click", () => fileInput.click());
  uploadZone.addEventListener("dragover", (e) => {
    e.preventDefault();
    uploadZone.classList.add("dragover");
  });
  uploadZone.addEventListener("dragleave", () => {
    uploadZone.classList.remove("dragover");
  });
  uploadZone.addEventListener("drop", (e) => {
    e.preventDefault();
    uploadZone.classList.remove("dragover");
    handleFiles(e.dataTransfer.files);
  });
  fileInput.addEventListener("change", () => {
    handleFiles(fileInput.files);
  });
  
  // Initial population of the image carousel
  updatePreviewCarousel();
});

// --- File Handling and Preview Logic ---

function handleFiles(files) {
  for (const file of files) {
    if (file.type.startsWith("image/")) {
      // Create a unique identifier for each file to prevent duplicates
      const fileId = file.name + file.size + file.lastModified;
      if (!selectedFiles.some(f => f.id === fileId)) {
        selectedFiles.push({
          id: fileId,
          file: file,
          isNew: true // Flag to distinguish from hard-coded images
        });
      }
    }
  }
  updatePreviewCarousel();
}

function updatePreviewCarousel() {
  const previewSlides = document.getElementById('preview-slides');
  previewSlides.innerHTML = '';
  currentSlideIndex = 0; // Reset to the first slide
  updateCarouselPosition();

  selectedFiles.forEach((fileObj, index) => {
    const slide = document.createElement('div');
    slide.classList.add('slide');
    
    // Check if the image is a new upload or a hard-coded URL
    if (fileObj.isNew) {
      const reader = new FileReader();
      reader.onload = function(e) {
        slide.style.backgroundImage = `url('${e.target.result}')`;
      };
      reader.readAsDataURL(fileObj.file);
    } else {
      slide.style.backgroundImage = `url('${fileObj.url}')`;
    }

    const deleteBtn = document.createElement("button");
    deleteBtn.classList.add("delete-image-btn");
    deleteBtn.innerHTML = '<i class="bi bi-x-lg"></i>';
    
    deleteBtn.onclick = (event) => {
      event.stopPropagation();
      removeFile(index);
    };

    slide.appendChild(deleteBtn);
    previewSlides.appendChild(slide);
  });
}

function removeFile(indexToRemove) {
  selectedFiles.splice(indexToRemove, 1);
  updatePreviewCarousel();
}

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