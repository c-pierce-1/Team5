<link rel="stylesheet" href="/css/navbar.css" />
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">

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
            <li><a class="dropdown-item" href="/profile">Favorites</a></li>
            <li><a class="dropdown-item" href="/my_listings">View My Listings</a></li>
            <li><a class="dropdown-item" href="/listing/create">Create a Listing</a></li>
          </ul>
        </div>
      </li>

      <li class="nav-item ms-3">
        <img src="/images/Logo.jpg" alt="Logo" width="100" height="50" />
      </li>
    </ul>

    <!-- RIGHT SIDE -->
    <div class="ms-auto nav-user-box">

      <!-- Only show if logged in -->
      <#if username??>
        <span class="nav-username">Welcome, ${username}!</span>
      </#if>

      <div class="dropdown">
        <button class="dropdown-toggle">
          <img src="/images/defaultuser.jpg" class="rounded-circle" width="40" height="40" />
        </button>

        <ul class="dropdown-menu-right">

          <#if username??>
            <li><a class="dropdown-item" href="/profile">My Profile</a></li>
            <li><a class="dropdown-item" href="/logout">Logout</a></li>
          </#if>

          <#if !username??>
            <li><a class="dropdown-item" href="/login">Login</a></li>
          </#if>

        </ul>
      </div>

    </div>

  </div>
</nav>

<script src="/scripting/navBar.js"></script>