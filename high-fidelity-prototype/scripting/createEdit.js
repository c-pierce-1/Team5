document.addEventListener("DOMContentLoaded", () => {
  const uploadZone = document.getElementById("upload-zone");
  const fileInput = document.getElementById("images");
  const previewSlides = document.getElementById("preview-slides");

  // This array will hold the files the user has selected
  let selectedFiles = [];

  // --- Drag and Drop Logic ---

  // Trigger the hidden file input when the user clicks the drop zone
  uploadZone.addEventListener("click", () => fileInput.click());

  // Add a class for styling when a file is dragged over
  uploadZone.addEventListener("dragover", (e) => {
    e.preventDefault();
    uploadZone.classList.add("dragover");
  });

  // Remove the class when the file leaves
  uploadZone.addEventListener("dragleave", () => {
    uploadZone.classList.remove("dragover");
  });

  // Handle the dropped files
  uploadZone.addEventListener("drop", (e) => {
    e.preventDefault();
    uploadZone.classList.remove("dragover");
    const files = e.dataTransfer.files;
    handleFiles(files);
  });

  // Handle files selected via the file input
  fileInput.addEventListener("change", () => {
    handleFiles(fileInput.files);
  });

  // --- File Handling and Preview Logic ---

  function handleFiles(files) {
    for (const file of files) {
      // Ensure it's an image and not already in the list
      if (file.type.startsWith("image/") && !selectedFiles.some(f => f.name === file.name)) {
        selectedFiles.push(file);
      }
    }
    updatePreviewCarousel();
  }

  function updatePreviewCarousel() {
    // Clear the existing previews
    previewSlides.innerHTML = "";

    // Create a new preview for each file in our array
    selectedFiles.forEach((file, index) => {
      const reader = new FileReader();

      reader.onload = function (e) {
        // Create the slide container
        const slide = document.createElement("div");
        slide.classList.add("slide");
        slide.style.backgroundImage = `url('${e.target.result}')`;

        // Create the delete button
        const deleteBtn = document.createElement("button");
        deleteBtn.classList.add("delete-image-btn");
        deleteBtn.innerHTML = '<i class="bi bi-x-lg"></i>'; // 'X' icon
        
        // Add a data attribute to know which file to delete
        deleteBtn.dataset.index = index; 

        // Add the delete functionality
        deleteBtn.onclick = (event) => {
          event.stopPropagation(); // Prevent other clicks from firing
          removeFile(index);
        };

        slide.appendChild(deleteBtn);
        previewSlides.appendChild(slide);
      };

      reader.readAsDataURL(file);
    });
  }

  function removeFile(indexToRemove) {
    // Remove the file from our array by its index
    selectedFiles.splice(indexToRemove, 1);
    // Refresh the carousel to show the change
    updatePreviewCarousel();
  }
});