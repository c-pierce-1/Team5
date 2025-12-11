// --- Global variable to track the current slide index ---
let currentSlideIndex = 0;

document.addEventListener("DOMContentLoaded", () => {
  const uploadZone = document.getElementById("upload-zone");
  const fileInput = document.getElementById("images");
  const previewSlides = document.getElementById("preview-slides");

  let selectedFiles = [];

  // --- Drag and Drop Logic ---
  // (This part is the same as your existing code)
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

  // --- File Handling and Preview Logic ---

  function handleFiles(files) {
    for (const file of files) {
      if (file.type.startsWith("image/") && !selectedFiles.some(f => f.name === file.name)) {
        selectedFiles.push(file);
      }
    }
    updatePreviewCarousel();
  }

  function updatePreviewCarousel() {
    previewSlides.innerHTML = "";
    currentSlideIndex = 0; // ADDED: Reset to the first slide
    updateCarouselPosition(); // ADDED: Update visual position

    selectedFiles.forEach((file, index) => {
      const reader = new FileReader();
      reader.onload = function (e) {
        const slide = document.createElement("div");
        slide.classList.add("slide");
        slide.style.backgroundImage = `url('${e.target.result}')`;

        const deleteBtn = document.createElement("button");
        deleteBtn.classList.add("delete-image-btn");
        deleteBtn.innerHTML = '<i class="bi bi-x-lg"></i>';
        deleteBtn.dataset.index = index;

        deleteBtn.onclick = (event) => {
          event.stopPropagation();
          removeFile(index);
        };

        slide.appendChild(deleteBtn);
        previewSlides.appendChild(slide);
      };
      reader.readAsDataURL(file);
    });
  }

  function removeFile(indexToRemove) {
    selectedFiles.splice(indexToRemove, 1);
    // Refresh the carousel to show the change
    updatePreviewCarousel();
  }
});

// --- NEW CAROUSEL NAVIGATION LOGIC ---

function updateCarouselPosition() {
  const slidesContainer = document.getElementById("preview-slides");
  // Move by 100% of the container width for each slide
  const offset = -currentSlideIndex * 100; 
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