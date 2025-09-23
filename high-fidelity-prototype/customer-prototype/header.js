document.querySelectorAll('.dropdown-toggle').forEach(button => {
    button.addEventListener('click', () => {
        const parent = button.closest('.dropdown');
        parent.classList.toggle('open');
    });
});


window.addEventListener('click', (e) => {
    if (!e.target.closest('.dropdown')) {
        document.querySelectorAll('.dropdown').forEach(drop => drop.classList.remove('open'));
    }
});
