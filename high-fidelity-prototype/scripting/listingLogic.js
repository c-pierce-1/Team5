let previewIndex = 0;

document.getElementById("images").addEventListener("change", function () {
  const slidesContainer = document.getElementById("preview-slides");
  slidesContainer.innerHTML = "";
  previewIndex = 0;

  Array.from(this.files).forEach(file => {
    const reader = new FileReader();
    reader.onload = function (e) {
      const img = document.createElement("img");
      img.src = e.target.result;
      slidesContainer.appendChild(img);
      updatePreviewSlide();
    };
    reader.readAsDataURL(file);
  });
});

function updatePreviewSlide() {
  const slides = document.querySelectorAll("#preview-slides img");
  const offset = -previewIndex * 100;
  document.getElementById("preview-slides").style.transform = `translateX(${offset}%)`;
}

function nextPreviewSlide() {
  const slides = document.querySelectorAll("#preview-slides img");
  if (slides.length === 0) return;
  previewIndex = (previewIndex + 1) % slides.length;
  updatePreviewSlide();
}

function prevPreviewSlide() {
  const slides = document.querySelectorAll("#preview-slides img");
  if (slides.length === 0) return;
  previewIndex = (previewIndex - 1 + slides.length) % slides.length;
  updatePreviewSlide();
}

document.getElementById("listing-form").addEventListener("submit", function (e) {
  e.preventDefault();
  const data = {
    name: document.getElementById("name").value,
    address: document.getElementById("address").value,
    desc: document.getElementById("desc").value,
    rules: document.getElementById("rules").value,
    images: Array.from(document.getElementById("images").files).map(file => file.name)
  };
  console.log("Listing saved:", data);
  alert("Listing saved successfully!");
});

document.getElementById("pick-prompt").addEventListener("click", () => {
  alert("Prompt picker coming soon!");
});