<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Create Listing</title>

  <link rel="stylesheet" href="/css/global.css" />
  <link rel="stylesheet" href="/css/navbar.css" />
  <link rel="stylesheet" href="/css/create-listing.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" />
</head>

<body>

  <nav class="navbar">
    <div class="container-fluid">

      <ul class="navbar-nav flex-row align-items-center">
        <li class="nav-item">
          <div class="dropdown">
            <button class="dropdown-toggle">
              <i class="bi bi-three-dots-vertical"></i>
            </button>
            <ul class="dropdown-menu-left">
              <li><a class="dropdown-item" href="/">Home</a></li>
              <li><a class="dropdown-item" href="/favorites">Favorites</a></li>
              <li><a class="dropdown-item" href="/my_listings">View My Listings</a></li>
              <li><a class="dropdown-item" href="/listing/create">Create a Listing</a></li>
            </ul>
          </div>
        </li>

        <li class="nav-item ms-3">
          <img src="/images/Logo.jpg" alt="Logo" width="100" height="50" />
        </li>
      </ul>

      <div class="ms-auto">
        <div class="dropdown">
          <button class="dropdown-toggle">
            <img src="/images/defaultuser.jpg" class="rounded-circle" width="40" height="40" />
          </button>
          <ul class="dropdown-menu-right">
            <li><a class="dropdown-item" href="/profile">My Profile</a></li>
            <li><a class="dropdown-item" href="/login">Login</a></li>
            <li><a class="dropdown-item" href="/logout">Logout</a></li>
          </ul>
        </div>
      </div>

    </div>
  </nav>


  <form action="/listing/create"
      method="post"
      enctype="multipart/form-data"
      id="listing-form">

  <div class="form-and-carousel">

      <!-- LEFT SIDE — IMAGES -->
      <div class="image-section">

          <div class="image-carousel">
              <div class="slides-listing" id="preview-slides"></div>

              <div class="nav">
                  <button type="button" onclick="prevPreviewSlide()">❮</button>
                  <button type="button" onclick="nextPreviewSlide()">❯</button>
              </div>
          </div>

          <div class="form-group">
              <label>Upload Images:</label>

              <div class="image-upload-zone" id="upload-zone">
                  <i class="bi bi-images"></i>
                  <p>Drag & drop images here, or click to select</p>
              </div>

              <input type="file" id="images" name="images" accept="image/*" multiple style="display:none;" />
          </div>

      </div>

      <!-- RIGHT SIDE — FORM -->
      <div class="listing-form-container">

          <div class="form-header">
              <h1>Create Listing</h1>
          </div>

          <#if errorMessage??>
              <div style="color:#b30000; margin-bottom:15px; font-weight:bold;">
                  ${errorMessage}
              </div>
          </#if>


          <div class="form-group">
              <label>Name:</label>
              <input type="text" name="name" placeholder="Enter listing name" required />
          </div>

          <div class="form-group">
              <label>Address:</label>
              <input type="text" name="address" placeholder="Enter address" required />
          </div>

          <div class="form-row">
              <div class="form-group">
                  <label>City:</label>
                  <input type="text" name="city" placeholder="Enter city" required />
              </div>

              <div class="form-group">
                  <label>State:</label>
                  <input type="text" name="state" placeholder="NC" required />
              </div>

              <div class="form-group">
                  <label>Zip Code:</label>
                  <input type="text" name="zipCode" placeholder="Enter ZIP Code" required />
              </div>
          </div>

          <div class="two-column-group">
              <div class="form-group">
                  <label>Bedrooms:</label>
                  <input type="number" name="bedrooms" step="0.5" placeholder="Bedrooms" required />
              </div>

              <div class="form-group">
                  <label>Bathrooms:</label>
                  <input type="number" name="bathrooms" step="0.5" placeholder="Bathrooms" required />
              </div>
          </div>

          <div class="form-group">
              <label>Description:</label>
              <textarea name="description" rows="4" placeholder="Enter description" required></textarea>
          </div>

          <h3>Price Per Night</h3>
          <input type="number" name="pricePerNight" placeholder="Enter Price Per Night" required />

          <h3>Rules</h3>
          <textarea name="rules" rows="5" placeholder="Enter rules or guidelines"></textarea>

          <div class="form-actions">
              <button type="submit">Save Listing</button>
              <button type="reset" class="clear-btn">
                  <i class="bi bi-trash"></i>
              </button>
          </div>

      </div>

  </div> <!-- END form-and-carousel -->

</form>


<script src="/scripting/navBar.js"></script>
<script src="/scripting/createEdit.js"></script>

</body>
</html>
