let currentSlideIndex = 0;

function updateCarouselPosition() {
    const slidesContainer = document.getElementById("preview-slides");
    const offset = -currentSlideIndex * 100;
    slidesContainer.style.transform = "translateX(" + offset + "%)";
}

function nextPreviewSlide() {
    const count = document.querySelectorAll(".slides-listing .slide").length;
    if (count === 0) return;
    currentSlideIndex = (currentSlideIndex + 1) % count;
    updateCarouselPosition();
}

function prevPreviewSlide() {
    const count = document.querySelectorAll(".slides-listing .slide").length;
    if (count === 0) return;
    currentSlideIndex = (currentSlideIndex - 1 + count) % count;
    updateCarouselPosition();
}

document.addEventListener("DOMContentLoaded", function () {
    updateCarouselPosition();
});