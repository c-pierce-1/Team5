document.addEventListener("DOMContentLoaded", () => {

    const uploadZone = document.getElementById("upload-zone");
    const fileInput = document.getElementById("images");
    const previewGrid = document.getElementById("preview-grid");
    const carouselNav = document.getElementById("carousel-nav");

    let currentIndex = 0;
    let previewImages = [];

    if (!uploadZone || !fileInput) {
        console.error("❌ Upload script failed: Missing elements.");
        return;
    }

    /* CLICK → open file dialog */
    uploadZone.addEventListener("click", () => fileInput.click());

    /* DRAG EVENTS */
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

        fileInput.files = e.dataTransfer.files;
        previewFiles(e.dataTransfer.files);
    });

    /* FILE PICKED NORMALLY */
    fileInput.addEventListener("change", () => {
        previewFiles(fileInput.files);
    });

    /* PREVIEW HANDLER */
    function previewFiles(files) {
        previewGrid.innerHTML = "";
        previewImages = [];

        Array.from(files).forEach((file, index) => {
            const reader = new FileReader();
            reader.onload = (e) => {
                previewImages.push(e.target.result);

                // Add to preview grid
                const img = document.createElement("img");
                img.src = e.target.result;
                img.classList.add("preview-img");
                previewGrid.appendChild(img);

                // Show carousel if multiple images
                if (previewImages.length > 1) {
                    carouselNav.style.display = "flex";
                }
            };
            reader.readAsDataURL(file);
        });

        currentIndex = 0;
    }

    /* CAROUSEL BUTTONS */
    window.nextPreview = function () {
        currentIndex = (currentIndex + 1) % previewImages.length;
        updateCarouselSelection();
    };

    window.prevPreview = function () {
        currentIndex = (currentIndex - 1 + previewImages.length) % previewImages.length;
        updateCarouselSelection();
    };

    function updateCarouselSelection() {
        const allImgs = previewGrid.querySelectorAll(".preview-img");

        allImgs.forEach((img, idx) => {
            img.style.outline = idx === currentIndex ? "3px solid #4a90e2" : "none";
        });

        // Auto-scroll into view
        allImgs[currentIndex].scrollIntoView({ behavior: "smooth", block: "center" });
    }

});
