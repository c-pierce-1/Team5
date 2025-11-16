//-------------------------------------------------
// IMAGE PREVIEW STATE
//-------------------------------------------------
let previewImages = [];
let currentIndex = 0;

const fileInput = document.getElementById("images");
const uploadZone = document.getElementById("upload-zone");
const previewContainer = document.getElementById("preview-slides");

//-------------------------------------------------
// UPDATE CAROUSEL UI
//-------------------------------------------------
function updatePreviewCarousel() {
    previewContainer.innerHTML = "";

    if (previewImages.length === 0) {
        previewContainer.innerHTML = `
            <div class="slide" style="display:flex;justify-content:center;align-items:center;">
                <p style="opacity:0.6;">No images selected</p>
            </div>
        `;
        return;
    }

    previewImages.forEach((src) => {
        const slide = document.createElement("div");
        slide.classList.add("slide");
        slide.style.backgroundImage = `url('${src}')`;
        previewContainer.appendChild(slide);
    });

    previewContainer.style.transform = `translateX(-${currentIndex * 100}%)`;
}

//-------------------------------------------------
// NEXT / PREV BUTTONS
//-------------------------------------------------
function nextPreviewSlide() {
    if (previewImages.length === 0) return;

    currentIndex = (currentIndex + 1) % previewImages.length;
    updatePreviewCarousel();
}

function prevPreviewSlide() {
    if (previewImages.length === 0) return;

    currentIndex = (currentIndex - 1 + previewImages.length) % previewImages.length;
    updatePreviewCarousel();
}

window.nextPreviewSlide = nextPreviewSlide;
window.prevPreviewSlide = prevPreviewSlide;

//-------------------------------------------------
// HANDLE FILES SELECTED (click OR drag)
//-------------------------------------------------
function handleFiles(files) {
    [...files].forEach(file => {
        const reader = new FileReader();
        reader.onload = (e) => {
            previewImages.push(e.target.result);
            updatePreviewCarousel();
        };
        reader.readAsDataURL(file);
    });
}

//-------------------------------------------------
// CLICK TO OPEN FILE PICKER
//-------------------------------------------------
uploadZone.addEventListener("click", () => fileInput.click());

// FILE INPUT CHANGE
fileInput.addEventListener("change", (e) => {
    handleFiles(e.target.files);
});

//-------------------------------------------------
// DRAG & DROP SUPPORT
//-------------------------------------------------
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

    if (e.dataTransfer.files.length > 0) {
        handleFiles(e.dataTransfer.files);
    }
});

// INITIAL UI
updatePreviewCarousel();
