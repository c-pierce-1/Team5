
    let currentSlideIndex = 0;

    function updateCarouselPosition() {
        const container = document.getElementById("preview-slides");
        const offset = -currentSlideIndex * 100;
        container.style.transform = "translateX(" + offset + "%)";
    }

    function nextPreviewSlide() {
        const slides = document.querySelectorAll(".slides-listing .slide");
        if (slides.length === 0) return;
        currentSlideIndex = (currentSlideIndex + 1) % slides.length;
        updateCarouselPosition();
    }

    function prevPreviewSlide() {
        const slides = document.querySelectorAll(".slides-listing .slide");
        if (slides.length === 0) return;
        currentSlideIndex = (currentSlideIndex - 1 + slides.length) % slides.length;
        updateCarouselPosition();
    }

    document.addEventListener("DOMContentLoaded", function () {
        // Init carousel
        updateCarouselPosition();

        // Favorite toggle
        const favoriteIcon = document.getElementById("favorite-icon");
        if (favoriteIcon) {
            favoriteIcon.addEventListener("click", function () {
                if (favoriteIcon.classList.contains("bi-heart-fill")) {
                    favoriteIcon.classList.remove("bi-heart-fill");
                    favoriteIcon.classList.add("bi-heart");
                } else {
                    favoriteIcon.classList.remove("bi-heart");
                    favoriteIcon.classList.add("bi-heart-fill");
                }
            });
        }
    });