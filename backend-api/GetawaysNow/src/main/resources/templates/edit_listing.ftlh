<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit ${listing.name}</title>

    <link rel="stylesheet" href="/css/global.css" />
    <link rel="stylesheet" href="/css/create-listing.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" />
</head>

<body>
<#if error??>
    <p style="color:red;">${error}</p>
</#if>


<#include "navbar.ftlh" />

<div class="form-and-carousel">

    <!-- LEFT: IMAGES -->
    <div class="image-section">

        <div class="image-carousel">
            <div class="slides-listing" id="preview-slides">
                <#if images?has_content>
                    <#list images as img>
                        <div class="slide existing-image"
                             style="background-image: url('${img.imagePath}');"
                             data-img-id="${img.id}">
                            <button class="delete-image-btn" onclick="markForDeletion(${img.id}, this)">
                                <i class="bi bi-x-lg"></i>
                            </button>
                        </div>
                    </#list>
                </#if>
            </div>

            <div class="nav">
                <button type="button" onclick="prevPreviewSlide()">❮</button>
                <button type="button" onclick="nextPreviewSlide()">❯</button>
            </div>
        </div>

        <div class="form-group">
            <label>Upload New Images:</label>

            <div class="image-upload-zone" id="upload-zone">
                <i class="bi bi-images"></i>
                <p>Drag & drop or click</p>
            </div>
        </div>

    </div>

    <!-- RIGHT: FORM -->
    <form action="/listing/${listing.id}/edit"
          method="post"
          enctype="multipart/form-data"
          id="edit-listing-form"
          class="listing-form-container">

        <!-- Required for deleted image IDs -->
        <div id="deleted-images-container"></div>

        <!-- Moved INSIDE the form — now the browser submits it -->
        <input type="file" id="images" name="images" accept="image/*" multiple style="display:none;">

        <h1>Edit Listing</h1>

        <input type="hidden" name="id" value="${listing.id}" />

        <div class="form-group">
            <label>Name:</label>
            <input type="text" name="name" value="${listing.name}" required>
        </div>

        <div class="form-group">
            <label>Address:</label>
            <input type="text" name="address" value="${listing.address}" required>
        </div>

        <div class="two-column-group">
            <div class="form-group">
                <label>City:</label>
                <input type="text" name="city" value="${listing.city}" required>
            </div>

            <div class="form-group">
                <label>State:</label>
                <input type="text" name="state" value="${listing.state}" required>
            </div>

            <div class="form-group">
                <label>Zip Code:</label>
                <input type="text" name="zipCode" value="${listing.zipCode}" required>
            </div>
        </div>

        <div class="two-column-group">
            <div class="form-group">
                <label>Bedrooms:</label>
                <input type="number" name="bedrooms" value="${listing.bedrooms}" required>
            </div>

            <div class="form-group">
                <label>Bathrooms:</label>
                <input type="number" step="0.5" name="bathrooms" value="${listing.bathrooms}" required>
            </div>
        </div>

        <div class="form-group">
            <label>Description:</label>
            <textarea name="description" rows="4">${listing.description}</textarea>
        </div>

        <div class="form-group">
            <label>Price Per Night:</label>
            <input type="number" name="pricePerNight" value="${listing.pricePerNight}" required>
        </div>

        <div class="form-group">
            <label>Rules:</label>
            <textarea name="rules" rows="3">${listing.rules!""}</textarea>
        </div>

        <button type="submit">Save Changes</button>

    </form>
</div>

<script src="/scripting/editListing.js"></script>

</body>
</html>
