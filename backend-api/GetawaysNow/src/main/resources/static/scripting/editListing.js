let currentSlideIndex = 0;
let selectedNewFiles = [];

document.addEventListener("DOMContentLoaded", () => {
    const uploadZone = document.getElementById("upload-zone");
    const fileInput = document.getElementById("images");

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
        handleNewFiles(e.dataTransfer.files);
    });

    fileInput.addEventListener("change", () => {
        handleNewFiles(fileInput.files);
    });
});

function handleNewFiles(files) {
    for (const file of files) {
        if (file.type.startsWith("image/")) {
            selectedNewFiles.push(file);
        }
    }
    refreshPreviewSlides();
}

function markForDeletion(id, btn) {
    const container = document.getElementById("deleted-images-container");

    const input = document.createElement("input");
    input.type = "hidden";
    input.name = "deleteImages";
    input.value = id;
    container.appendChild(input);

    const slide = btn.closest(".existing-image");
    slide.remove();
}




function refreshPreviewSlides() {
    const container = document.getElementById("preview-slides");

    container.querySelectorAll(".new-image-preview").forEach(e => e.remove());

    selectedNewFiles.forEach(file => {
        const reader = new FileReader();
        reader.onload = function(e) {
            const slide = document.createElement("div");
            slide.className = "slide new-image-preview";
            slide.style.backgroundImage = `url('${e.target.result}')`;

            container.appendChild(slide);
        };
        reader.readAsDataURL(file);
    });

    updateCarouselPosition();
}


function updateCarouselPosition() {
    const slides = document.querySelectorAll("#preview-slides .slide");
    if (slides.length === 0) return;
    currentSlideIndex = Math.min(currentSlideIndex, slides.length - 1);
    document.getElementById("preview-slides").style.transform =
        `translateX(-${currentSlideIndex * 100}%)`;
}

function nextPreviewSlide() {
    const slides = document.querySelectorAll("#preview-slides .slide").length;
    currentSlideIndex = (currentSlideIndex + 1) % slides;
    updateCarouselPosition();
}

function prevPreviewSlide() {
    const slides = document.querySelectorAll("#preview-slides .slide").length;
    currentSlideIndex = (currentSlideIndex - 1 + slides) % slides;
    updateCarouselPosition();
}
