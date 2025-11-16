document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('login-form');

    if (form) {
        form.addEventListener('submit', function (e) {
            e.preventDefault();
            if (form.checkValidity()) {
                window.location.href = 'home.html';
            } else {
                form.reportValidity();
            }
        });
    }
});

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('signup-form');

    if (form) {
        form.addEventListener('submit', function (e) {
            e.preventDefault();
            if (form.checkValidity()) {
                window.location.href = 'home.html';
            } else {
                form.reportValidity();
            }
        });
    }
});

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('signup-form');

    if (form) {
        form.addEventListener('submit', function (e) {
            e.preventDefault();

            const password = document.getElementById('inputPassword').value;
            const confirmPassword = document.getElementById('confirmPassword').value;

            if (!form.checkValidity()) {
                form.reportValidity();
                return;
            }

            if (password !== confirmPassword) {
                alert("Passwords do not match!");
                return;
            }

            window.location.href = 'home.html';
        });
    }
});