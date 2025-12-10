<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>My Profile</title>
  
  <link rel="stylesheet" href="/Style-Sheet.css" />
</head>

<body>

  <#include "navbar.ftlh" />

  <div class="profile-container">
    <!-- Header -->
    <div class="profile-header">
      <h1>Profile Page</h1>
    </div>

    <!-- Profile Image -->
    <div class="profile-image">
      <label for="upload">
        <img src="/default user.jpg" alt="Profile" class="avatar" />
      </label>
    </div>

    <!-- Info Fields -->
    <form class="profile-info" action="/profile/update" method="POST">

      <input type="hidden" name="profileId" value="${profile.profileId}">

      <div class="info-row">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" class="edit-input" value="${profile.username}">
      </div>

      <div class="info-row">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" class="edit-input" value="${profile.firstName!""}">
      </div>

      <div class="info-row">
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" class="edit-input" value="${profile.lastName!""}">
      </div>

      <div class="info-row">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" class="edit-input" value="${profile.email!""}">
      </div>

      <div class="info-row">
        <label for="phoneNum">Phone:</label>
        <input type="text" id="phoneNum" name="phoneNum" class="edit-input" value="${profile.phoneNum!""}">
      </div>

      <div>
            <label for="password">New Password:</label>
            <input type="password" id="password" name="password" 
                   placeholder="Leave blank to keep current password">
        </div>

      <div class="info-row">
        <button type="submit" class="save-btn">Save Changes</button>
      </div>

    </form>

    <!-- Stats -->
    <div class="profile-stats">
    </div>

    <hr>

    <h3>My Favorites</h3>
    <div>
      <#list profile.favorites as favorite>
        <div class="favorite-card">
          <p>${favorite.listing.name}</p>
          <a href="/listing/${favorite.listing.id}">View</a>
        </div>
      </#list>
    </div>

  </div>
</body>

</html>