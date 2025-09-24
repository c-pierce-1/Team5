function myFunction() {
  var x = document.getElementById("inputPassword");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}

function passwordRule() {
  const passwordInput = document.getElementById("inputPassword");
  if (passwordInput) {
    passwordInput.addEventListener("keydown", function (e) {
      if (e.code === "Space") {
        e.preventDefault();
      }
    });
  }
}
passwordRule();
